package racing;

import java.util.List;

public class CarNamesDto {

	private final List<String> carNames;

	private CarNamesDto(List<String> carNames) {
		this.carNames = carNames;
	}

	public static CarNamesDto of(List<String> carNames) {
		return new CarNamesDto(carNames);
	}

	public List<String> getCarNames() {
		return carNames;
	}
}
