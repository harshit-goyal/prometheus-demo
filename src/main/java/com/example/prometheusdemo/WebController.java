package com.example.prometheusdemo;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    private MeterRegistry meterRegistry;
    private Counter counter;

    public WebController(MeterRegistry meterRegistry){
        this.meterRegistry = meterRegistry;
        buildCounter();
    }

    @GetMapping("/test")
    public String test(@RequestParam("number") Integer number){
        System.out.println(number);
        incrementCounter();
        return "ok";
    }

    public void buildCounter(){
        this.counter = Counter.builder("my_test_counter").register(meterRegistry);
    }

    public void incrementCounter(){
        this.counter.increment();
    }
}
