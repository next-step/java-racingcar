package racingcar.ui;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.CarStadium;

public class ResultView {
	private final InputView inputView;

	public ResultView(InputView inputView) {
		this.inputView = inputView;
	}

	public void showResult() {
		CarStadium carStadium = new CarStadium(inputView);

		int rounds = carStadium.getRounds();
		List<Car> cars = carStadium.getCars();

		System.out.println();
		System.out.println("실행 결과");
		for (int i = 0; i < rounds; i++) {
			resultMoveCar(cars);
			System.out.println();
		}
	}

	private void resultMoveCar(List<Car> cars) {
		for (int i = 0; i < cars.size(); i++) {
			// 자동차 이동
			Car car = cars.get(i);
			car.move();
			System.out.println(car.carStatus());
		}
	}
}
