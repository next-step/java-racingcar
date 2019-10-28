package step2.domain.rules;

public abstract class RaceRoundRule {

	private int raceRoundNumber;

	RaceRoundRule(int raceRoundNumber) {
		this.raceRoundNumber = validate(raceRoundNumber);
	}

	public abstract int validate(int raceRoundNumber);

	public int getRaceRoundNumber() {
		return raceRoundNumber;
	}

}
