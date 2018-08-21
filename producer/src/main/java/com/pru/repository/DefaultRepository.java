package com.pru.repository;

import com.pru.domain.Job;
import org.springframework.data.repository.CrudRepository;

public interface DefaultRepository extends CrudRepository<Job, String> {
}
