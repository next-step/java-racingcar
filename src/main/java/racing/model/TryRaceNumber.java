package racing.model;

import racing.util.StringValid;

public class TryRaceNumber {

	private int tryRaceNumber;

	public TryRaceNumber(String userInputString) {

		if (!StringValid.isNumber(userInputString)) {
			throw new IllegalArgumentException("숫자만 입력해 주세요.");
		}

		this.tryRaceNumber = Integer.parseInt(userInputString);
	}

	/**
	 * 유저가 입력한 주행 횟수만큼 레이싱 반복 메서드
	 * @return 유저 입력 수와 0 비교, 다르면 true, 같으면 false (비교 후 1 감소)
	 */
	public boolean isTryGame() {

		return (this.tryRaceNumber--) != 0;
	}
}
