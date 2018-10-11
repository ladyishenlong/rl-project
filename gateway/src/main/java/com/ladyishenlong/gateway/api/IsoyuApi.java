package com.ladyishenlong.gateway.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Repository
@FeignClient("isoyu-api")
@ApiIgnore
public interface IsoyuApi {

    @GetMapping("/helloIsoyu")
    String helloIsoyu();





}
