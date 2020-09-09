package com.bntang666.provider;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class ZuulFallBackProvider implements FallbackProvider {
    /**
     * 制定为哪个微服务提供回退（这里写微服务名,写 * 代表所有微服务）
     *
     * @return
     */
    @Override
    public String getRoute() {
        return "*";
    }

    /**
     * 此方法需要返回一个ClientHttpResponse对象,ClientHttpResponse是一个接口，具体的回退逻辑要实现此接口
     *
     * @param route
     * @param cause
     * @return
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        // 这里可以判断根据不同的异常来做不同的处理，也可以不判断,完了之后调用response方法并根据异常类型传入HttpStatus
        if (cause instanceof HystrixTimeoutException) {
            return response(HttpStatus.GATEWAY_TIMEOUT);
        } else {
            return response(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private ClientHttpResponse response(final HttpStatus status) {
        // 这里返回一个 ClientHttpResponse 对象，并实现其中的方法，关于回退逻辑的详细，便在下面的方法中
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                // 返回一个HttpStatus对象，这个对象是个枚举对象，里面包含了一个 status code 和 reasonPhrase 信息
                return status;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                // 返回status的code  比如 404，500等
                return status.value();
            }

            @Override
            public String getStatusText() throws IOException {
                // 返回一个HttpStatus对象的reasonPhrase信息
                return status.getReasonPhrase();
            }

            @Override
            public void close() {
                // close的时候调用的方法, 讲白了就是当降级信息全部响应完了之后调用的方法
                System.out.println("close调用");
            }

            @Override
            public InputStream getBody() throws IOException {
                // 把降级信息响应回前端
                return new ByteArrayInputStream("系统繁忙,请稍后再试".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                // 需要对响应报头设置的话可以在此设置
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}