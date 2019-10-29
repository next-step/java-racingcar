package step2.domain.rules;

public abstract class CarNameRule {

	private String[] carNames;

	CarNameRule(String carNamesBeforeParsed) {
		this.carNames = parse(carNamesBeforeParsed);
	}

	public abstract String[] parse(String carNamesBeforeParsed);

	public String[] getCarNames() {
		return carNames;
	}

}
