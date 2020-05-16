package domain;

import dto.CalculateInfo;

public class Calculator{
	public int calculate(CalculateInfo calculateInfo) {
		return calculateInfo.calculate();
	}
}
