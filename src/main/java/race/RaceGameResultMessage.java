package race;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaceGameResultMessage {
	public static final String MESSAGE_SEPARATOR = "";
	public static final String CAR_SEPARATOR = "\n";
	public static final String TRY_SEPARATOR = "\n\n";
	public static final String DISTANCE_SEPARATOR = "-";
	public static final String RESULT_MESSAGE_FORMAT = "%s : %s";

	private final List<Car> cars;

	public RaceGameResultMessage(List<Car> cars) {
		this.cars = cars;
	}

	public String parser() {
		return cars.stream()
			.map(this::amountToSeparatorParser)
			.collect(Collectors.joining(CAR_SEPARATOR));
	}

	private String amountToSeparatorParser(Car car) {
		return String.format(RESULT_MESSAGE_FORMAT, car.getNameValue(), parseSeparator(car.nowDistance()));
	}

	private String parseSeparator(int distance) {
		return IntStream.range(Car.START_DISTANCE, distance)
			.mapToObj(i -> DISTANCE_SEPARATOR)
			.collect(Collectors.joining(MESSAGE_SEPARATOR));
	}

	public String getDistanceWinner() {
		return cars.stream().collect(Collectors.toMap(
			Car::nowDistance,
			Car::getNameValue,
			(existWinner, addWinner) -> existWinner + CarGroup.INPUT_NAME_SEPARATOR + addWinner,
			TreeMap::new))
			.lastEntry()
			.getValue();
	}
}
