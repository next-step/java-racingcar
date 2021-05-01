package racingcar;

public class RacingCar {
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
}
