package util;

public class ValidationUtils {
	public static boolean isEmpty(String targetString) {
		if("".equals(targetString) || targetString == null) {
			throw new IllegalArgumentException("공백이 입력 되었습니다. 입력 값을 확인해주세요.");
		}
		return true;
	}
	
	public static boolean isOperator(String targetString) {
		if("+".equals(targetString)) {
			return true;
		}
		
		if("-".equals(targetString)) {
			return true;
		}
		
		if("*".equals(targetString)) {
			return true;
		}
		
		if("/".equals(targetString)) {
			return true;
		}
		
		throw new IllegalArgumentException("연산자가 아닌 기호가 입력되었습니다. 입력 값을 확인해주세요.");
	}
}
