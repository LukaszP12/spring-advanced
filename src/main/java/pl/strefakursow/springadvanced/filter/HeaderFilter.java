package pl.strefakursow.springadvanced.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(2)
public class HeaderFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse newResponse = (HttpServletResponse) response;
        newResponse.addHeader("strefakursow","jest najlepsza");

        chain.doFilter(request,newResponse);

    }


}
