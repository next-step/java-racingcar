package racingcar.domain;

public class CarRandomNumberGenerator implements CarNumberGenerator {

	public static final int MAXIMUM_NUMBER = 9;

	@Override
	public int generate() {
		return CarUtil.makeRandomNumber(MAXIMUM_NUMBER);
	}
}
