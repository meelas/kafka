package com.pru.domain;

import java.util.UUID;

public class Job {
    private UUID id;
    private Service service;

    public Job() {
        this.id = UUID.randomUUID();
    }

    public Job(Service service) {
        super();
        this.service = service;
    }

    public String getId() {
        return id.toString();
    }

    public Service getService() {
        return service;
    }
}
