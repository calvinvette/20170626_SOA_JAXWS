package com.trivera.costservice;

import static org.junit.Assert.*;
import org.junit.Test;

import com.trivera.costservice.generated.CostService;
import com.trivera.costservice.generated.CostService_Service;

public class TestCostService {

	@Test
	public void testCostValid() {
		assertEquals("1024 * 10 should be 10240.0 (F)", 10240.F, 
				new CostService_Service().getCostServiceSOAP().calculateCost(1024), 0.000000001);
	}

	
	
	public static void main(String[] args) {
//		CostService_Service proxy = new CostService_Service();
//		CostService svc = proxy.getCostServiceSOAP();
//		System.out.println(svc.calculateCost(1024));
		
		float result = new CostService_Service().getCostServiceSOAP().calculateCost(1024);
		System.out.println("Should be 10240.0: " + (result == 10240.0F));
	}

}
