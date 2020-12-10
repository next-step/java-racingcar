package racing.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCarGroup {
	private final List<RacingCar> racingCarList;

	public static RacingCarGroup of(List<String> carNameList, MoveChanceGenerator moveChanceGenerator) {
		List<RacingCar> racingCarList = new ArrayList<>();
		for (String carName : carNameList) {
			final RacingCar racingCar = new RacingCar(carName, moveChanceGenerator);
			racingCarList.add(racingCar);
		}

		return new RacingCarGroup(racingCarList);
	}

	RacingCarGroup(List<RacingCar> racingCarList) {
		this.racingCarList = racingCarList;
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
		OptionalInt maxPosition = getMaxPosition();
		if (!maxPosition.isPresent()) {
			return Collections.emptyList();
		}

		return this.racingCarList.stream()
				.filter(racingCar -> racingCar.isEqualPosition(maxPosition.getAsInt()))
				.map(RacingCar::getCarName)
				.collect(Collectors.toList());
	}

	private OptionalInt getMaxPosition() {
		return this.racingCarList.stream()
				.mapToInt(RacingCar::getPosition)
				.max();
	}

	public int size() {
		return racingCarList.size();
	}
}
