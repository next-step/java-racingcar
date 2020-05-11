package stringCalculator;

public class StringCalculator extends Calculator{
	
	public int calculate(String operation) {
		String[] targetStringS = operation.split(" ");
		int result = Integer.parseInt(targetStringS[0]);
		for(int i=1;i<targetStringS.length;i+=2) {
			if("+".equals(targetStringS[i])) {
				result = add(result,Integer.parseInt(targetStringS[i+1]));
			}
			else if("-".equals(targetStringS[i])) {
				result = subStract(result, Integer.parseInt(targetStringS[i+1]));
			}
			else if("*".equals(targetStringS[i])) {
				result = multifly(result, Integer.parseInt(targetStringS[i+1]));
			}
			else if("/".equals(targetStringS[i])) {
				result = devide(result, Integer.parseInt(targetStringS[i+1]));
			}
		}
		
		return result;
	}
}
