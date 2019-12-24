package br.com.blueclover.blog.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringWebXmlConfig implements WebApplicationInitializer{

	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(SpringMvcConfig.class);
		webContext.setServletContext(servletContext);
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webContext);
		dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
		
		ServletRegistration.Dynamic reDynamic = servletContext.addServlet("dispacher", dispatcherServlet);
		reDynamic.setLoadOnStartup(1);
		reDynamic.addMapping("/");
		
		FilterRegistration.Dynamic encondingFilter = servletContext.addFilter("encondingFilter", new CharacterEncodingFilter());
		encondingFilter.setInitParameter("enconding", "UTF-8");
		encondingFilter.setInitParameter("forceEnconding", "true");
		encondingFilter.addMappingForUrlPatterns(null, true, "/*");
	}
	
	
}
