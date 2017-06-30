package trivera.axis;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * <p>
 * This component and its source code representation are copyright protected and
 * proprietary to Trivera Technologies, LLC, Worldwide D/B/A Trivera
 * Technologies
 *
 * This component and source code may be used for instructional and evaluation
 * purposes only. No part of this component or its source code may be sold,
 * transferred, or publicly posted, nor may it be used in a commercial or
 * production environment, without the express written consent of Trivera
 * Technologies, LLC
 *
 * Copyright (c) 2017 Trivera Technologies, LLC. http://www.triveratech.com
 * </p>
 * 
 * @author Trivera Technologies Tech Team.
 */
@WebService
public class Calculator {
	@WebMethod // Explicit, but unnecessary
	public int add(int i1, int i2) {
		return i1 + i2;
	}

	public int subtract(int i1, int i2) {
		return i1 - i2;
	}

	public float fahrenheitToCelsius(float degreesFahrenheit) {
		return (degreesFahrenheit - 32) / 9 * 5;
	}
}
