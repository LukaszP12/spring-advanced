package pl.strefakursow.springadvanced.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(1)
public class FirstFilter implements Filter {

    //it is called by the webcontainer to inform, that the filter is used in the application, right after the creation of a filter instance
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    // This method does the filtering
    // We use filterChain to make sure that the HTTP request goes further until it has reached the reasource
    // it can also be processed to a another filter
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter");
        chain.doFilter(request,response);
    }

    // it is called to inform that the filter is being stopped
    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
