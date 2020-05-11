package domain;

import dto.CalculateInfo;
import util.ValidationUtils;

public class StringCalculator extends Calculator{
	
	public int stringCalculate(String operation) {
		
		ValidationUtils.isEmpty(operation);
		
		String[] targetStringS = operation.split(" ");
		int result = Integer.parseInt(targetStringS[0]);
		CalculateInfo calculateInfo = new CalculateInfo();
		
		for(int i=1;i<targetStringS.length;i+=2) {
			ValidationUtils.isOperator(targetStringS[i]);
			
			calculateInfo.setNum1(result);
			calculateInfo.setNum2(Integer.parseInt(targetStringS[i+1]));
			calculateInfo.setOperator(targetStringS[i]);
			
			result = calculate(calculateInfo);
		}
		
		return result;
	}
}
