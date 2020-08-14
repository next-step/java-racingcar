package racingWinner;

public class StringUtil {
	
	public static boolean isEmpty(String value) {
		if(value == null) {
			return false;
		}
		
		if("".equals(value)) {
			return false;
		}
		
		return true;
	}
}
