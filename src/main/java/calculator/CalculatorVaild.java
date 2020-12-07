package calculator;

import util.UserOutput;

public class CalculatorVaild {

	public static void validCalculatorString(String userInput) {

		if (isBank(userInput)) {
			throw new IllegalArgumentException(UserOutput.USER_ERROR_MSG_IS_BANK);
		}

		String[] userInputArr = userInputArr(userInput);

		if (!isNumbers(userInputArr)) {
			throw new IllegalArgumentException(UserOutput.USER_ERROR_MSG_IS_NUMBER);
		}

		if (!isRegulars(userInputArr)) {
			throw new IllegalArgumentException(UserOutput.USER_ERROR_MSG_IS_CORRECT);
		}
	}

	/**
	 * 빈값 체크 메서드
	 * @param inputStr: 유저 입력 계산식 문자열
	 * @return 문자열이 비어잇으면 True, 아니면 False
	 */
	public static boolean isBank(String inputStr) {

		return removeBlank(inputStr).length() <= 0;
	}

	/**
	 * 유저 입력 계산식 중 숫자 판단 메서드
	 * @param inputNumber : 유저 입력 중 홀수자리
	 * @return 숫자면 True, 아니면 False
	 */
	public static boolean isNumber(String inputNumber) {

		try {
			Integer.parseInt(inputNumber);
			return true;
		} catch (NumberFormatException numberFormatException) {
			return false;
		}
	}

	/**
	 * 유저 입력 계산식 중에 수번째 자리 숫자입력 확인 메서드
	 * @param userInput : 유저 입력 계산식 " " 기준으로 나눈 문자열 배열
	 * @return 전체가 숫자라면 True, 아니면 False
	 */
	public static boolean isNumbers(String[] userInput) {

		boolean result = true;
		for (int i = 0; i < userInput.length; i += 2) {
			result &= isNumber(userInput[i]);
		}

		return result;
	}

	/**
	 * 유저 계산식 입력 전체가 " " 기준으로 나누었을때, 홀수개인지 판단(올바른 계산식이라면 항상 홀수)
	 * @param userInputArr : 유저 입력 계산식 " " 기준으로 나눈 문자열 배열
	 * @return 홀수가이면 True, 아니면 False
	 */
	private static boolean isRegulars(String[] userInputArr) {

		return userInputArr.length % 2 == 1;
	}

	/**
	 * 유저 입력 계산식을 " " 공백 기준으로 나누어주는 메서드
	 * @param userInput: 유저 입력 계산식
	 * @return " " 공백 기준으로 나눈 문자열 배열
	 */
	private static String[] userInputArr(String userInput) {

		return userInput.split(" ");
	}

	/**
	 * 공백 지우는 메서드
	 * @param inputString: 유저 입력 문자열
	 * @return " " 공백을 전부 지운 문자열
	 */
	private static String removeBlank(String inputString) {

		return inputString.replaceAll(" ", "");
	}
}
