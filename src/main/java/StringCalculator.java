import org.junit.platform.commons.util.StringUtils;

public class StringCalculator {
	
	public int plus(int i, int j) {
		return i+j;
	}
	
	public int minus(int i, int j) {
		return i-j;
	}
	
	public int multiply(int i, int j) {
		return i*j;
	}
	
	public int divide(int i, int j) {
		return i/j;
	}
	
	public int calc(String str) {
		if(StringUtils.isBlank(str)) throw new IllegalArgumentException("String is Empty");
		
		String[] splits = str.split(" ");		
		
		int currentNum = Integer.parseInt(splits[0]);
		for(int i = 1 ; i < splits.length-1 ; i += 2) {
			String operation = splits[i];
			int operateNum = Integer.parseInt(splits[i+1]);
			
			switch(operation) {
				case "+":
					currentNum = plus(currentNum, operateNum);
				break;
				case "-":
					currentNum = minus(currentNum, operateNum);
				break;
				case "*":
					currentNum = multiply(currentNum, operateNum);
				break;
				case "/":
					currentNum = divide(currentNum, operateNum);
				break;
				default:
					throw new IllegalArgumentException("Invalide operation");
			}
		}
		
		return currentNum;
	}
	
}
