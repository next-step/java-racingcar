package simpleracing.output;

import static java.util.stream.Collectors.toMap;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;

import simpleracing.execute.Car;
import simpleracing.execute.Direction;

public class OutputView {
	private final List<Car> cars;
	private final Map<Car, StringBuilder> renderingMap;

	public OutputView(List<Car> cars) {
		this.cars = cars;
		this.renderingMap = cars.stream()
								.collect(toMap(Function.identity(), car -> new StringBuilder()));
	}

	public void render() {
		System.out.println("실행 결과");

		IntStream.range(0, this.getTryCount())
				 .forEach(currentRound -> executeRendering(currentRound));
	}

	private int getTryCount() {
		return cars.get(0)
				   .getTryCount();
	}

	private void executeRendering(int currentRound) {
		cars.stream()
			.forEach(car -> {
				this.appendCurrentRoundResult(car, currentRound);
				System.out.println(renderingMap.get(car));
			});

		System.out.println();
	}

	private void appendCurrentRoundResult(Car car, int currentRound) {
		List<Direction> directions = car.getDirections();
		renderingMap.get(car)
					.append(directions.get(currentRound)
									  .getSign());
	}
}
