package com.bntang666.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tangyihao
 * @version V1.1.1
 * @program springcloud-netflix
 * @date Created in 2020/9/9 11:19
 * @description
 **/
@Component
public class LoginFilter extends ZuulFilter {

    /**
     * 返回过滤器的类型
     *
     * @return 前置过滤器
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 返回指定过滤器的执行顺序，越小越靠前执行
     *
     * @return +1，在此过滤器之后执行
     */
    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 1;
    }

    /**
     * 判断该过滤器是否要执行，true表示执行，false表示不执行
     *
     * @return 执行该过滤器
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器具体要做的逻辑
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String remoteAddr = request.getRemoteAddr();
        System.out.println("访问者IP：" + remoteAddr + "访问地址：" + request.getRequestURI());

        // 可以通过 application.yml 配置文件中的 strip-prefix: false/true，确定是否要移除前缀
        System.out.println("路由后的地址：" + ctx.get(FilterConstants.REQUEST_URI_KEY));
        return null;
    }
}