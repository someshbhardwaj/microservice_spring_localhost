package com.learningwithsomesh.microservices.netflixzuulapigatewayserver;


import javax.servlet.http.HttpServletRequest;

//import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import java.util.logging.Logger;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Object run() throws ZuulException {
		//HttpServletRequest request= RequestContext.getCurrentContext().getRequest();
		HttpServletRequest request = 
				RequestContext.getCurrentContext().getRequest();

		//logger.info("SOMESH request -> {} request uri -> {}" + request + " "+ request.getRequestURI());
		logger.info("SOMESH request -> {} request uri -> {}", 	request, request.getRequestURI());

		return null;
		
	}

//WE can put our business logic and apply that to filter the incoming logs	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
