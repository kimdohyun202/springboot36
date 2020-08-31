package ksmart36.mybatis.interceptor;

import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class CommonInterceptor implements HandlerInterceptor{ 

	
	private static final Logger log = LoggerFactory.getLogger(CommonInterceptor.class);

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// controller 진행 전
		log.info("CommonInterceptor===============================START");
		log.info("ACCES INFO======================================START");
		log.info("port			::::()",request.getLocalPort());
		log.info("serverName 	::::()",request.getServerName());
		log.info("getMethod 	::::()",request.getMethod());
		log.info("getRequestURI ::::()",request.getRequestURI());
		log.info("ACCES INFO======================================END");
		System.out.println("memberId"+request.getParameter("memberId"));
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// controller 진행 후
		log.info("CommonInterceptor===============================END");

		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
}
