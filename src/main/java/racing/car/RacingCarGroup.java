package racing.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RacingCarGroup {
	private final List<RacingCar> racingCarList;

	public static RacingCarGroup of(List<CarName> carNameList, MoveChanceGenerator moveChanceGenerator) {
		List<RacingCar> racingCarList = new ArrayList<>();
		for (CarName carName : carNameList) {
			final RacingCar racingCar = new RacingCar(carName, moveChanceGenerator);
			racingCarList.add(racingCar);
		}

		return new RacingCarGroup(racingCarList);
	}

	RacingCarGroup(List<RacingCar> racingCarList) {
		this.racingCarList = racingCarList;
	}

	public void getMoveForwardChance() {
		for (RacingCar racingCar : this.racingCarList) {
			racingCar.getMoveForwardChance();
		}
	}

	public List<CarName> getWinnerNameList() {
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

	public List<String> getToStringList(Function<RacingCar, String> stringMapper) {
		return this.racingCarList.stream()
				.map(stringMapper)
				.collect(Collectors.toList());
	}
}
