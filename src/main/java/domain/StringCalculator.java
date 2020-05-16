package domain;

import util.ValidationUtils;

public class StringCalculator extends Calculator{

	public int stringCalculate(String operations) {
		
		ValidationUtils.isEmpty(operations);
		
		String[] targetStrings = operations.split(" ");
		int result = Integer.parseInt(targetStrings[0]);
		
		for(int i=1;i<targetStrings.length;i+=2) {
			ValidationUtils.isOperator(targetStrings[i]);
			
			CalculateInfo calculateInfo = new CalculateInfo(result, Integer.parseInt(targetStrings[i+1]), targetStrings[i]); 
			result = calculate(calculateInfo);
		}
		
		return result;
	}
}
