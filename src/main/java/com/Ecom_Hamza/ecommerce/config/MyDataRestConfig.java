package com.Ecom_Hamza.ecommerce.config;

import com.Ecom_Hamza.ecommerce.entity.Product;
import com.Ecom_Hamza.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        HttpMethod[] theUnsupprtedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        // disable HTTP method put ,Post, Delete For Product
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupprtedActions) )
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupprtedActions));

        // disable HTTP method put ,Post, Delete for ProductCategory
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupprtedActions) )
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupprtedActions));
    }
}
