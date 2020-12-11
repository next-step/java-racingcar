package racing.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RacingCarGroup {
	public static final String MESSAGE_EMPTY_CAR_LIST = "racingCarList 가 비어있습니다.";
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
		if (racingCarList.size() == 0) {
			throw new IllegalArgumentException(MESSAGE_EMPTY_CAR_LIST);
		}
		this.racingCarList = racingCarList;
	}

	public void getMoveForwardChance() {
		for (RacingCar racingCar : this.racingCarList) {
			racingCar.getMoveForwardChance();
		}
	}

	public List<CarName> getWinnerNameList() {
		int maxPosition = getMaxPosition();

		return this.racingCarList.stream()
				.filter(racingCar -> racingCar.isEqualPosition(maxPosition))
				.map(RacingCar::getCarName)
				.collect(Collectors.toList());
	}

	private int getMaxPosition() {
		return this.racingCarList.stream()
				.mapToInt(RacingCar::getPosition)
				.max()
				.orElseThrow(() -> new IllegalArgumentException(MESSAGE_EMPTY_CAR_LIST));
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
