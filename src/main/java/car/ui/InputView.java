package car.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import car.exception.CarNameLengthException;
import car.exception.TryCountMissMatchException;

public class InputView {

	private static final String CAR_NAMES_TEXT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String TRY_COUNT_TEXT = "시도할 회수는 몇 회 인가요?";
	private static final String CAR_NAME_LENGTH_EXCEPTION_TEXT = "자동차 이름은 5자를 초과할 수 없습니다. 다시 시도하세요.";
	private static final String TRY_COUNT_MISS_MATCH_EXCEPTION_TEXT = "시도 횟수 입력값이 올바르지 않습니다. 다시 시도하세요.";
	private static final String CAR_NAMES_TEXT_DELIMITER = ",";
	private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
	private static final Scanner SCANNER = new Scanner(System.in);

	public String[] carNames;
	public int tryCount;

	public void input() throws Exception {
		try {
			this.inputCarNames();
			this.checkCarName();
			this.inputTryCount();
		} catch (CarNameLengthException | TryCountMissMatchException e) {
			throw new Exception(e);
		}
	}

	private void inputCarNames() {
		System.out.println(CAR_NAMES_TEXT);
		this.carNames = SCANNER.next().split(CAR_NAMES_TEXT_DELIMITER);
	}

	private void inputTryCount() {
		try {
			System.out.println(TRY_COUNT_TEXT);
			this.tryCount = SCANNER.nextInt();
		} catch (InputMismatchException ime) {
			throw new TryCountMissMatchException(TRY_COUNT_MISS_MATCH_EXCEPTION_TEXT);
		}
	}

	public void checkCarName() {
		for (String carName : this.carNames) {
			this.checkCarNameLength(carName);
		}
	}

	private void checkCarNameLength(String carName) {
		if (carName.length() > MAXIMUM_CAR_NAME_LENGTH) {
			throw new CarNameLengthException(CAR_NAME_LENGTH_EXCEPTION_TEXT);
		}
	}
}
