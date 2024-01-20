package com.example.dto;

import lombok.Data;

@Data
public class SearchResponseDTO {

	private String name;
	private Long mobile;
	private String email;
	private Character gender;
	private Long ssn;
	private String PlanName;
	private String planStatus;
}
