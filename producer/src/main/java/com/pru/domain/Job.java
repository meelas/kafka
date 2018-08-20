package com.pru.domain;

import java.util.UUID;

public class Job {
    private UUID id;

    public Job() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }
}
