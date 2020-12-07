package race;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaceGameResultMessage {
	public static final String MESSAGE_SEPARATOR = "";
	public static final String TRY_SEPARATOR = "\n";
	public static final String DISTANCE_SEPARATOR = "-";

	private final int tryTimes;
	private final List<Car> cars;

	public RaceGameResultMessage(int tryTimes, CarGroup cars) {
		this.tryTimes = tryTimes;
		this.cars = cars.nowCarStatus();
	}

	public int getTryTimes() {
		return tryTimes;
	}

	public String parser() {
		return cars.stream()
			.map(this::amountToSeparatorParser)
			.collect(Collectors.joining(TRY_SEPARATOR));
	}

	private String amountToSeparatorParser(Car car) {
		String message = "";
		if (car.getName() != null && !"".equals(car.getName())) {
			message += car.getName() + " : ";
		}
		message += IntStream.range(Car.START_DISTANCE, car.nowDistance())
			.mapToObj(i -> DISTANCE_SEPARATOR)
			.collect(Collectors.joining(MESSAGE_SEPARATOR));
		return message;
	}
}
