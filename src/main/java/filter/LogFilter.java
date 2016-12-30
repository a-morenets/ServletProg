package filter;

import javax.servlet.*;
import javax.servlet.Filter;
import java.util.Date;

/**
 * Created by Виктор on 01.11.14.
 */
public class LogFilter /*extends com.sun.net.httpserver.Filter*/ implements Filter {
    public void init(FilterConfig config) throws ServletException {
        // Get init parameter
        String testParam = config.getInitParameter("test-param");

        //Print the init parameter
        System.out.println("Test Param: " + testParam);
    }

    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws java.io.IOException, ServletException {

        // Get the IP address of client machine.
        String ipAddress = request.getRemoteAddr();

        // Log the IP address and current timestamp.
        System.out.println("IP " + ipAddress + ", Time " + new Date().toString());

        // Pass request back down the filter chain
        chain.doFilter(request, response);
    }

    public void destroy() {
      /* Called before the Filter instance is removed
      from service by the web container*/
    }
}
