package filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * Created by gabri on 2016-02-14.
 */
public class LogTimeFilter implements Filter {
    double startTime, endTime;
    String ipAddress;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        startTime = Double.parseDouble(filterConfig.getInitParameter("start-time"));
        System.out.println("Request start time: " + startTime);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ipAddress = servletRequest.getRemoteAddr();

        System.out.println("IP "+ ipAddress + ", Time "
                + new Date().toString());

    }

    @Override
    public void destroy() {

    }
}
