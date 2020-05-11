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

	private int calculate(CalculateInfo calculateInfo) {
		
		if("+".equals(calculateInfo.getOperator())) {
			return add(calculateInfo.getNum1(), calculateInfo.getNum2());
		}
		
		if("-".equals(calculateInfo.getOperator())) {
			return subStract(calculateInfo.getNum1(), calculateInfo.getNum2());
		}
		
		if("*".equals(calculateInfo.getOperator())) {
			return multifly(calculateInfo.getNum1(), calculateInfo.getNum2());
		}
		
		if("/".equals(calculateInfo.getOperator())) {
			return devide(calculateInfo.getNum1(), calculateInfo.getNum2());
		}
		
		return 0;
	}
}
