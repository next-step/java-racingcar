package racingcar;

public class RacingCar {
	private static final int DEFAULT_BASE_NUMBER = 3;
	private static final int GO = 1;
	private Name name;
	private Score totalScore;

	public RacingCar(String name) {
		this.name = new Name(name);
		this.totalScore = new Score();
	}

	public String getName() {
		return name.getName();
	}

	public int getTotalScore() {
		return totalScore.getScore();
	}

	public int move(int number) {
		if (number > DEFAULT_BASE_NUMBER) {
			totalScore.add(GO);
		}
		return getTotalScore();
	}
}
