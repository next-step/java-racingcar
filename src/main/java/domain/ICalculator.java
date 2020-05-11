package domain;

import dto.CalculateInfo;

public interface ICalculator {
	
	public int add(int num1, int num2);
	public int subStract(int num1, int num2);
	public int multifly(int num1, int num2);
	public int devide(int num1, int num2);
	public int calculate(CalculateInfo calculateInfo);
}
