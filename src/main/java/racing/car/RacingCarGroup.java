package racing.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCarGroup {
	private final List<RacingCar> racingCarList;

	public static RacingCarGroup of(List<String> carNameList, MoveForwardStrategy moveForwardStrategy) {
		List<RacingCar> racingCarList = new ArrayList<>();
		for (String carName : carNameList) {
			final RacingCar racingCar = createCar(carName, moveForwardStrategy);
			racingCarList.add(racingCar);
		}

		return new RacingCarGroup(racingCarList);
	}

	RacingCarGroup(List<RacingCar> racingCarList) {
		this.racingCarList = racingCarList;
	}

	private static RacingCar createCar(String carName, MoveForwardStrategy moveForwardStrategy) {
		return new RacingCar(carName, moveForwardStrategy);
	}

	public Stream<RacingCar> stream() {
		return this.racingCarList.stream();
	}

	public void getMoveForwardChance() {
		for (RacingCar racingCar : this.racingCarList) {
			racingCar.getMoveForwardChance();
		}
	}

	public List<String> getWinnerNameList() {
		OptionalInt maxPosition = this.stream()
				.mapToInt(RacingCar::getPosition)
				.max();

		if (!maxPosition.isPresent()) {
			return Collections.emptyList();
		}

		List<String> winnerNameList = this.stream()
				.filter(racingCar -> racingCar.getPosition() == maxPosition.getAsInt())
				.map(RacingCar::getCarName)
				.collect(Collectors.toList());

		return winnerNameList;
	}
}
