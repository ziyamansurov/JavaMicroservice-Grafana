//package com.task.mentortask.filter;
//
//import org.slf4j.LoggerFactory;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.util.logging.Logger;
//
//@Component
//public class LoggingFilter implements GlobalFilter, Ordered {
//
//    private static final Logger log = (Logger) LoggerFactory.getLogger(LoggingFilter.class);
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        log.info("Incoming request: {}", exchange.getRequest().getPath());
//        return chain.filter(exchange).then(Mono.fromRunnable(() ->
//                log.info("Response status: {}", exchange.getResponse().getStatusCode())
//        ));
//    }
//
//    @Override
//    public int getOrder() {
//        return -1; // highest priority
//    }
//}
////```
////
////        ---
////
////        ## How It Works
////```
////Client Request
////      │
////              ▼
////API Gateway (:8080)
////      │
////              ├─ /api/users/**  ──►  USER-SERVICE  (via Eureka)
//// │
//// └─ /api/orders/** ──►  ORDER-SERVICE (via Eureka)
//// ```
//
//
////
//// ## Startup Order
//// ```
//// 1. Eureka Server → 2. Microservices → 3. API Gateway