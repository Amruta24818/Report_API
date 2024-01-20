package com.example.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.dto.SearchRequestDTO;
import com.example.dto.SearchResponseDTO;
import com.example.model.EligibilityDetails;
import com.example.repo.EligibilityDetailsRepo;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class EligibilityServiceImpl implements IEligibilityService {

	@Autowired
	private EligibilityDetailsRepo detailsRepo;

	@Override
	public List<String> getUniquePlanName() {
		return detailsRepo.findPlanNames();

	}

	@Override
	public List<String> getPlanStatus() {
		// TODO Auto-generated method stub
		return detailsRepo.findPlanStatus();
	}

	@Override
	public List<SearchResponseDTO> getSearch(SearchRequestDTO requestDTO) {
		EligibilityDetails queryBuilder = new EligibilityDetails();
		List<SearchResponseDTO> response = new ArrayList<>();

		String planName = requestDTO.getPlanName();

		if (planName != null && !planName.equals("")) {
			queryBuilder.setPlanName(planName);
		}

		String planStatus = requestDTO.getPlanStatus();

		if (planStatus != null && !planStatus.equals("")) {
			queryBuilder.setPlanStatus(planStatus);
		}
		
		LocalDate startDate = requestDTO.getPlanStartDate();
		
		if(startDate!= null) {
			queryBuilder.setPlanStratDate(startDate);
		}
		
		LocalDate endDate = requestDTO.getPlanEndDate();
		
		if(endDate!= null) {
			queryBuilder.setPlanEndDate(endDate);
		}
		
		Example<EligibilityDetails> example = Example.of(queryBuilder);
		
		List<EligibilityDetails> entities = detailsRepo.findAll(example);
		
		for(EligibilityDetails entity: entities) {
			SearchResponseDTO sr = new SearchResponseDTO();
			
			BeanUtils.copyProperties(entities, sr);
			
			response.add(sr);
		}

		return response;
	}

	@Override
	public void generateExcel(HttpServletResponse httpServletResponse) {
		// TODO Auto-generated method stub

	}

	@Override
	public void generatePdf(HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
