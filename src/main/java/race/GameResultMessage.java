package race;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResultMessage {
	private final String separator;

	public GameResultMessage(String separator) {
		this.separator = separator;
	}

	public String parser(List<Car> target) {
		return target.stream()
			.map(this::amountToSeparatorParser)
			.collect(Collectors.joining("\n"));
	}

	private String amountToSeparatorParser(Car car) {
		return IntStream.range(0, car.nowDistance())
			.mapToObj(i -> this.separator) //i is an int, not an Integer
			.collect(Collectors.joining(""));
	}
}
