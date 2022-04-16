package racingcar.ui;

import racingcar.domain.Car;
import racingcar.domain.CarStadium;
import racingcar.domain.Cars;

public class ResultView {
	private final InputView inputView;

	public ResultView(InputView inputView) {
		this.inputView = inputView;
	}

	public void showResult() {
		CarStadium carStadium = new CarStadium(inputView);
		carStadium.carComes();

		int rounds = carStadium.getRounds();
		Cars cars = carStadium.getCars();

		System.out.println();
		System.out.println("실행 결과");
		for (int i = 0; i < rounds; i++) {
			resultMoveCar(cars);
			System.out.println();
		}
	}

	private void resultMoveCar(Cars cars) {
		for (int i = 0; i < cars.count(); i++) {
			Car car = cars.get(i);
			car.move();
			System.out.println(car.carStatus());
		}
	}
}
