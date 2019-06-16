package com.study.pattern.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.pattern.entity.HealthCheck;
import com.study.pattern.repository.HealthCheckRepository;
import com.study.pattern.request.ChangeHealthCheckStatusRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/healthcheck")
public class HealthCheckController {

	
	@Autowired
	HealthCheckRepository healthCheckRepository;
	
	
	@PostMapping("/toggle-status")
	public void changeHealthCheckStatus(@RequestBody ChangeHealthCheckStatusRequest req) {		
		HealthCheck entity = healthCheckRepository.getOne(1L);
		log.info("Invoking the changeHealthCheckStatus {} ",entity);
		entity.setStatus(req.isStatus());
		HealthCheck save = healthCheckRepository.save(entity);
		log.info("Invoking the changeHealthCheckStatus {} ",save);
	}
	
	
	@GetMapping("/sayHello")
	public ResponseEntity<String> sayHello() {		
		HealthCheck entity = healthCheckRepository.getOne(1L);
		log.info("Invoking the changeHealthCheckStatus {} ",entity);
		if(entity.isStatus()) {
			return ResponseEntity.ok("sayHello");
		}else
			throw new RuntimeException();
	}
	
}
