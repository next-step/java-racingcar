package simpleracing.output;

import java.util.List;

import simpleracing.execute.Car;
import simpleracing.view.OutputView;

public class CarRacingOutput implements OutputView {

	private String result;

	public CarRacingOutput() {
		result = "";
	}

	@Override
	public void addRenderingView(List<Car> cars) {
		cars.stream()
			.forEach(car -> result += car.getLocation() + "\n");

		result += "\n";
	}

	@Override
	public void render() {
		System.out.println("실행 결과");
		System.out.println(result);
	}
}
