package com.study.pattern.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "HEALTH_CHECK")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HealthCheck {

	@Id
	@Column(name = "ID")
	private Long id; // The row number!

	@Column(name = "STATUS", nullable = false)
	private boolean status;

}
