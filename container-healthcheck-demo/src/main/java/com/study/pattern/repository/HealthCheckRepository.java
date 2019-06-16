package com.study.pattern.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.pattern.entity.HealthCheck;


@Transactional
public interface HealthCheckRepository extends JpaRepository<HealthCheck, Long> {

}
