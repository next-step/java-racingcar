package domain;

import dto.CalculateInfo;

public interface Calculator {
	
	int add(int num1, int num2);
	int subtract(int num1, int num2);
	int multiply(int num1, int num2);
	int divide(int num1, int num2);
	int calculate(CalculateInfo calculateInfo);
}
