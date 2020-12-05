package race;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResultMessage {
	public static final String MESSAGE_SEPARATOR = "";
	public static final String TRY_SEPARATOR = "\n";
	private final String separator;

	public GameResultMessage(String separator) {
		this.separator = separator;
	}

	public String parser(List<Car> target) {
		return target.stream()
			.map(this::amountToSeparatorParser)
			.collect(Collectors.joining(TRY_SEPARATOR));
	}

	private String amountToSeparatorParser(Car car) {
		return IntStream.range(Car.START_DISTANCE, car.nowDistance())
			.mapToObj(i -> this.separator) //i is an int, not an Integer
			.collect(Collectors.joining(MESSAGE_SEPARATOR));
	}
}
