package com.example.service;

import java.util.List;

import com.example.dto.SearchRequestDTO;
import com.example.dto.SearchResponseDTO;

import jakarta.servlet.http.HttpServletResponse;

public interface IEligibilityService {
	
	public List<String> getUniquePlanName();
	
	public List<String> getPlanStatus();
	
	public List<SearchResponseDTO> getSearch(SearchRequestDTO requestDTO);
	
	public void generateExcel(HttpServletResponse httpServletResponse);
	
	public void generatePdf(HttpServletResponse response);

}
