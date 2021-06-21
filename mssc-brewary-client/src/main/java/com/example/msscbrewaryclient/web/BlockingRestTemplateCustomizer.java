package com.example.msscbrewaryclient.web;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class BlockingRestTemplateCustomizer implements RestTemplateCustomizer {

    private final Integer maxTotalConnection;
    private final Integer defaultMaxTotalConnetion;
    private final Integer connectionRequestTimeout;
    private final Integer socketTime;

    public BlockingRestTemplateCustomizer(@Value("${sfg.maxtotalconnection}") Integer maxTotalConnection,
                                          @Value("${sfg.defaultmaxtotalconnetion}") Integer defaultMaxTotalConnetion,
                                          @Value("${sfg.connectionrequesttimeout}") Integer connectionRequestTimeout,
                                          @Value("${sfg.sockettime}") Integer socketTime) {
        this.maxTotalConnection = maxTotalConnection;
        this.defaultMaxTotalConnetion = defaultMaxTotalConnetion;
        this.connectionRequestTimeout = connectionRequestTimeout;
        this.socketTime = socketTime;
    }

    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.setRequestFactory(this.clientRequestFactory());
    }

    private ClientHttpRequestFactory clientRequestFactory() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(maxTotalConnection);
        connectionManager.setDefaultMaxPerRoute(defaultMaxTotalConnetion);

        RequestConfig requestConfig = RequestConfig
                .custom()
                .setConnectTimeout(connectionRequestTimeout)
                .setSocketTimeout(socketTime)
                .build();
        CloseableHttpClient httpClient = HttpClients
                .custom()
                .setConnectionManager(connectionManager)
                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                .setDefaultRequestConfig(requestConfig)
                .build();
        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }
}
