package racing;

public class Constant {
	/**
	 * 상태
	 */
	public static final int FIRST_WINNER = 0;

	/**
	 * 제약 조건
	 */
	public static final int CAR_NAME_MAX_LENGTH = 5;
	public static final int CONDITION_BOUNDARY_VALUE = 4;
	public static final int CONDITION_MAX_RANDOM_VALUE = 10;

	/**
	 * 구분자, 표기
	 */
	public static final String DELIMITER = ",";
	public static final String PROGRESS_BAR = "-";

	/**
	 * 에러 문구
	 */
	public static final String ERR_EMPTY_CARS = "참가하는 자동차가 없습니다.";
	public static final String ERR_CAR_NAME_LENGTH = "자동차의 이름 길이는 0보다 크고 5보다 작거나 같아야 합니다.";
}
