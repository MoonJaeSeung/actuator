package hello.order.v2;

import hello.order.OrderService;
import hello.order.v1.OrderServiceV1;
import io.micrometer.core.aop.CountedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfigV2 {

    @Bean
    public OrderService orderService(){
        return new OrderServiceV2();
    }

    //CountedAspect를 빈으로 등록하지 않으면 @counted 관련 AOP가 동작하지 않는다.
    @Bean
    public CountedAspect countedAspect(MeterRegistry registry) {
        return new CountedAspect(registry);
    }
}
