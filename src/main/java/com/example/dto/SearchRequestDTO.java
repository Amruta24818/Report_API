package com.example.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SearchRequestDTO {

	private String planName;
	private String planStatus;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
}
