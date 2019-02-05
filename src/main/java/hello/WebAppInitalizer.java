package hello;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
@EnableWebMvc
@ComponentScan("hello")
public class WebAppInitalizer extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/*"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{WebAppInitalizer.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    // map URLs matching /** to "static" from resources
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    // redirect requests without qualified url path to index.html
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/index.html");
    }

}