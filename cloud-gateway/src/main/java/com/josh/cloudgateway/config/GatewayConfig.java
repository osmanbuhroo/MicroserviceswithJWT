package com.josh.cloudgateway.config;

import com.josh.cloudgateway.filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEurekaClient
public class GatewayConfig {
//
//    @Autowired
//    private JwtAuthenticationFilter filter;
//
//    @Bean
//    public RouteLocator routes(RouteLocatorBuilder builder) {
//        return builder.routes().route("JWT-Authentication", r -> r.path("/api/v1/auth/**").filters(f -> f.filter(filter)).uri("lb://JWT-Authentication"))
//                .route("User-Service", r -> r.path("/users/**").filters(f -> f.filter(filter)).uri("lb://User-Service"))
//                .route("Department-Service", r -> r.path("/Departments/**").filters(f -> f.filter(filter)).uri("lb://Department-Service"))
//                .build();
//    }
//
//}

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("JWT-Authentication", r -> r.path("/api/v1/auth/**")
                        .filters(f -> f.filter(jwtAuthenticationFilter))
                        .uri("lb://JWT-Authentication"))
                .route("User-Service", r -> r.path("/users/**")
                        .filters(f -> f.filter(jwtAuthenticationFilter))
                        .uri("lb://User-Service"))
                .route("Department-Service", r -> r.path("/departments/**")
                        .filters(f -> f.filter(jwtAuthenticationFilter))
                        .uri("lb://Department-Service"))
                .build();
    }
}