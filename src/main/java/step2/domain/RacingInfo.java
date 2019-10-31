package step2.domain;

class RacingInfo {

	private static final int INITIAL_ROUND = 0;

	private int currentRound;
	private final int maxRound;

	RacingInfo(int maxRound) {
		this.currentRound = INITIAL_ROUND;
		this.maxRound = maxRound;
	}

	boolean isNotEndRace() {
		return currentRound != maxRound;
	}

	void validateInProgressCarRace() {
		if (currentRound >= maxRound) {
			throw new IllegalStateException(String.format("현재 경기 횟수(%s)는 최대 경기 횟수(%s)에 도달했습니다!",
					currentRound, maxRound));
		}
	}

	void updateOneRound() {
		currentRound++;
	}

	void validateFinishCarRace() {
		if (currentRound < maxRound) {
			throw new IllegalStateException(String.format("현재 경기 횟수(%s)는 최대 경기 횟수(%s)에 도달하지 못했습니다!",
					currentRound, maxRound));
		}
	}

	int getCurrentRound() {
		return currentRound;
	}

}
