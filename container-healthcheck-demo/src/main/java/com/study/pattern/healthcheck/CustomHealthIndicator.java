package com.study.pattern.healthcheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;

import com.study.pattern.entity.HealthCheck;
import com.study.pattern.repository.HealthCheckRepository;

public class CustomHealthIndicator extends AbstractHealthIndicator {

	@Autowired
	HealthCheckRepository healthCheckRepository;

	@Override
	protected void doHealthCheck(Health.Builder builder) throws Exception {
		HealthCheck entity = healthCheckRepository.getOne(1L);
		if (entity.isStatus()) {
			builder.up();
		} else {
			builder.down();
		}
	}
}
