package racing;

import racing.model.Car;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingCar {

	Random random = new Random();

	public void main() {
		InputView inputView = new InputView();
		inputView.inputUI();

		List<Car> carList = createRacingCar(inputView.getPlayCarCount());

		ResultView resultView = new ResultView();
		for (int i = 0; i < inputView.getPlayCount(); i++) {
			playRacing(carList);

			resultView.printResult(carList);

		}
	}

	private void playRacing(List<Car> carList) {
		for (int i = 0; i < carList.size(); i++) {
			int result = random.nextInt(10);
			if (result >= 4) {
				Car car = carList.get(i);
				car.forward();
			}
		}
	}

	private List<Car> createRacingCar(int playCarCount) {
		List<Car> carList = new ArrayList<>();
		for (int i = 0; i < playCarCount; i++) {
			Car car = new Car(i, 0);
			carList.add(car);
		}
		return carList;
	}
}
