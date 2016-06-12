package ua.sasa;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import ua.sasa.dao.CommonDao;
import ua.sasa.dao.ImagesDao;
import ua.sasa.service.ImagesDriver;

@Configuration
public class MainConfig extends WebMvcConfigurerAdapter {

    @Value("${store.dir}")
    private String storeDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        File dir = new File(storeDir);
        if (dir != null) {
            dir.mkdirs();
        }
        registry.addResourceHandler("/store/**").addResourceLocations("file:///" + storeDir);
    }

    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory() {
        return new HibernateJpaSessionFactoryBean();
    }

    @Bean
    public CommonDao commonDao() {
        return new CommonDao();
    }

    @Bean
    public ImagesDao imagesDao() {
        return new ImagesDao();
    }

    @Bean
    public ImagesDriver imageDriver() {
        return new ImagesDriver();
    }
}
