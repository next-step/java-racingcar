package simpleracing.output;

import java.util.List;
import java.util.stream.Collectors;

import simpleracing.execute.Car;
import simpleracing.execute.Direction;

public class CarRacingOutput {

	private static final String WINNER_CONTENT = "우승자는 %s입니다.";
	private String result;

	public CarRacingOutput() {
		result = Direction.STOP.getSign();
	}

	public void addSituation(List<Car> cars) {
		cars.stream()
			.forEach(car -> result += car.getName() + " : " + car.getLocation() + "\n");

		result += "\n";
	}

	public void addWinner(List<Car> cars) {
		result += String.format(WINNER_CONTENT, cars.stream()
													.map(car -> car.getName())
													.collect(Collectors.joining("와 ")));
	}

	public void render() {
		System.out.println("실행 결과");
		System.out.println(result);
	}
}
