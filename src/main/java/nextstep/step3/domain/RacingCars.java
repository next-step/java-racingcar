package nextstep.step3.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCars {

	private static final String INPUT_CARNAME_REQUIRED = "자동차 이름은 필수 입력 입니다.";
	private static final String CARNAME_IS_BELOW_FIVE = "자동차 이름은 5자를 넘길 수 없습니다.";
	private List<RacingCar> racingCars;
	private String carNames;

	public RacingCars(String carNames) {
		this.carNames = carNames;
		this.racingCars = getCarNames().stream()
				.map(RacingCar::new)
				.collect(Collectors.toList());
	}

	protected List<String> getCarNames() {
		if (carNames.isEmpty()) {
			throw new IllegalArgumentException(INPUT_CARNAME_REQUIRED);
		}
		String[] names = carNames.split(",");
		return Stream.of(names)
				.peek(name -> {
					if (name.length() > 5) {
						throw new IllegalArgumentException(CARNAME_IS_BELOW_FIVE);
					}
				})
				.collect(Collectors.toList());
	}

	public List<RacingCar> getRacingCars() {
		return racingCars;
	}

	public List<String> getRacingWinnerNames() {
		int maxPoint = racingCars.stream()
				.max(Comparator.comparing(RacingCar::getPoint))
				.get().getPoint();

		return racingCars.stream()
				.filter(car -> maxPoint == car.getPoint())
				.map(RacingCar::getName)
				.collect(Collectors.toList());
	}
}
