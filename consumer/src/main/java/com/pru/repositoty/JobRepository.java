package com.pru.repositoty;

import com.pru.domain.entity.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Long>{
}
