package nextstep.step3.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCars {
	private static final int RANDOM_BOUND = 10;
	private static final RandomGenerator randomGenerator = new RandomGenerator(RANDOM_BOUND);
	private static final String INPUT_CARNAME_REQUIRED = "자동차 이름은 필수 입력 입니다.";
	private static final String CARNAME_IS_BELOW_FIVE = "자동차 이름은 5자를 넘길 수 없습니다.";
	private List<RacingCar> racingCars;

	public RacingCars(String carNames) {
		this.racingCars = getRacingCars(carNames);
	}

	protected List<RacingCar> getRacingCars(String carNames) {
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
				.map(RacingCar::new)
				.collect(Collectors.toList());
	}

	public List<RacingCar> getRacingCars() {
		return racingCars;
	}

	public void move() {
		for (RacingCar racingCar : racingCars) {
			racingCar.move(randomGenerator.getRandomNumber());
		}
	}
	public List<String> getRacingWinnerNames() {
		int maxPoint = getMaxPoint();
		return racingCars.stream()
				.filter(car -> maxPoint == car.getPoint())
				.map(RacingCar::getName)
				.collect(Collectors.toList());
	}

	private int getMaxPoint() {
		return racingCars.stream()
					.max(Comparator.comparing(RacingCar::getPoint))
					.get().getPoint();
	}
}
