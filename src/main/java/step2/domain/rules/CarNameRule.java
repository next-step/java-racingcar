package step2.domain.rules;

public abstract class CarNameRule {

	private String[] carNames;

	CarNameRule(String carNamesBeforeParsed, String delimiter) {
		this.carNames = parse(carNamesBeforeParsed, delimiter);
	}

	public abstract String[] parse(String carNamesBeforeParsed, String delimiter);

	public String[] getCarNames() {
		return carNames;
	}

}
