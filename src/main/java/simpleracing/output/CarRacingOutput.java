package simpleracing.output;

import java.util.List;
import java.util.stream.Collectors;

import simpleracing.execute.Car;
import simpleracing.execute.CarGame;
import simpleracing.execute.Direction;

public class CarRacingOutput {

	private String result;

	public CarRacingOutput() {
		result = Direction.STOP.getSign();
	}

	public void addRenderingView(List<Car> cars) {
		cars.stream()
			.forEach(car -> result += car.getName() + " : " + car.getLocation() + "\n");

		result += "\n";
	}

	public void addWinner(CarGame racingGame) {
		result += "우승자는 " +
				  racingGame.getWinner()
							.stream()
							.map(car -> car.getName())
							.collect(Collectors.joining("와 "))
				  + "입니다.";
	}

	public void render() {
		System.out.println("실행 결과");
		System.out.println(result);
	}
}
