package com.objectway.stage.examples.logging.filter;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;

/**
 * Filter that adds a {@code requestID} to the MDC.
 * <p>Spring Boot automatically adds this filter to the servlet filter chain.
 */
@Component
public class RequestIdFilter implements Filter {
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		try {
			// Populate the MDC
			final UUID uniqueId = UUID.randomUUID();
			MDC.put("requestId", uniqueId.toString());

			// Continue the filter chain
			filterChain.doFilter(servletRequest, servletResponse);
		} finally {
			// Clean up the MDC
			MDC.remove("requestId");
		}
	}
}
