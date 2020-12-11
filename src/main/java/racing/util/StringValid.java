package racing.util;

public class StringValid {

	/**
	 * 문자열 벨리데이션 메서드
	 * @param validStr: 유저 입력 문자열
	 * @return null 이거나, 빈값이면 true, 아니면 false
	 */
	public static boolean isEmptyStr(String validStr) {

		return validStr == null || validStr.trim().isEmpty();
	}

	/**
	 * 숫자 벨리데이션 메서드
	 * @param validStr: 주행 횟수 유저 입력
	 * @return 숫자면 true, 아니면 false 리턴
	 */
	public static boolean isNumber(String validStr) {

		try {
			Integer.parseInt(validStr);
			return true;
		} catch (NumberFormatException numberFormatException) {
			return false;
		}
	}

}
