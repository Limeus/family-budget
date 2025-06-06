package com.limeus.apigateway.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExpenseServiceRouteConfig {
    @Bean
    public RouteLocator expenseRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("expense-service-route", r -> r
                        .path("/v1/expenses/**")
                        .uri("lb://EXPENSE-SERVICE"))
                .build();
    }
}
