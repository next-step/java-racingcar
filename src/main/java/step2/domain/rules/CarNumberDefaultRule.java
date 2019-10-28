package step2.domain.rules;

public class CarNumberDefaultRule extends CarNumberRule {

	private static int MIN_CAR_NUMBER = 1;

	public CarNumberDefaultRule(int carNumber) {
		super(carNumber);
	}

	@Override
	public int validate(int carNumber) {
		if (carNumber < MIN_CAR_NUMBER) {
			throw new IllegalArgumentException(
					String.format("차 대수는 %s대 미만일 수 없습니다. 입력해주신 차 대수(%s)를 확인해주세요!",
							MIN_CAR_NUMBER, carNumber));
		}
		return carNumber;
	}

}
