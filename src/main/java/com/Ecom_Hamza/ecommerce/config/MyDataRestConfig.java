package com.Ecom_Hamza.ecommerce.config;

import com.Ecom_Hamza.ecommerce.entity.Country;
import com.Ecom_Hamza.ecommerce.entity.Product;
import com.Ecom_Hamza.ecommerce.entity.ProductCategory;
import com.Ecom_Hamza.ecommerce.entity.State;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        HttpMethod[] theUnsupprtedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        // disable HTTP method put ,Post, Delete For Product
        disableHttpMethods(Product.class ,config, theUnsupprtedActions);
        // disable HTTP method put ,Post, Delete for ProductCategory
        disableHttpMethods(ProductCategory.class ,config, theUnsupprtedActions);

        // disable HTTP method put ,Post, Delete For Country
        disableHttpMethods(Country.class ,config, theUnsupprtedActions);
        // disable HTTP method put ,Post, Delete For State
        disableHttpMethods(State.class ,config, theUnsupprtedActions);

        // call an internal helper method
        exposeIds(config);
    }

    private void disableHttpMethods(Class theClass ,RepositoryRestConfiguration config, HttpMethod[] theUnsupprtedActions) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupprtedActions) )
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupprtedActions));
    }

    private void exposeIds(RepositoryRestConfiguration config) {

        // expose entity ids
        //

        // - get a list of all entity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // - create an array of the entity types
        List<Class> entityClasses = new ArrayList<>();

        // - get the entity types for the entities
        for (EntityType tempEntityType : entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }

        // - expose the entity ids for the array of entity/domain types
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }
}

