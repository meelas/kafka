package com.pru.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Service {
    G1("G1 service"), H1("H1 service"), P1("P1 service");

    String serviceName;

    Service(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    private static final List<Service> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Service randomService()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
