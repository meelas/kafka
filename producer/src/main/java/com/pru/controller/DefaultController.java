package com.pru.controller;

import com.pru.domain.Job;
import com.pru.service.DefaultService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
@Api
public class DefaultController {

    private DefaultService jobService;

    @Autowired
    public DefaultController(DefaultService jobService) {
        this.jobService = jobService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/submit")
    @ApiOperation(value = "submit job for specific service")
    public ResponseEntity<Job> register(@RequestParam(value = "service") String service) {

        Job result = jobService.submitJob(service);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
