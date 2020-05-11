package step1;

public class StringStudy {

	/**
	 * 문자열(param)을 구분자(delimiter)로 split한다.
	 * 
	 * @param param     : String, 나눌 문자
	 * @param delimiter : String, 구분자
	 * @return String[], 구분자로 나뉘어진 문자를 배열로 반환한다.
	 */
	public String[] splitTest(String param, String delimiter) {
		return param.split(delimiter);
	}

	/**
	 * 문자열(param)의 괄호를 제거한다.
	 * 
	 * @param param : String, 괄호를 제거할 문자
	 * @return String, 괄호가 제거된 문자를 반환한다.
	 */
	public String removeBracket(String param) {
		
		param = removeCharacter(param, "(");
		param = removeCharacter(param, ")");
		
		return param;
	}
	
	/**
	 * 문자열(param)에서 문자(target)를 제거한다.
	 * 
	 * @param param : String, 문자를 제거할 문자열
	 * @param target : String, 제거할 문자
	 * @return String, 문자가 제거된 문자를 반환한다.
	 */
	private String removeCharacter(String param, String target) {
		int index = 0;
		String left = "";
		String right = "";
		
		while((index = param.indexOf(target))!=-1) {
			left = param.substring(0,index);
			right = param.substring(index+1, param.length());
			param = left+right;
		}
		
		return param;
	}
	
	/**
	 * 문자열(param)에서 특정 위치(index)의 문자를 가져온다.
	 * @param param : String, 문자를 가져올 문자열
	 * @param index : int, 문자를 가져올 위치
	 * @return String 특정 위치의 문자
	 */
	public char charAtTest(String param, int index) {
		return param.charAt(index);
	}
}