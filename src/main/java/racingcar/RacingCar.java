package racingcar;

import static racingcar.InputView.inputCarNumber;
import static racingcar.InputView.inputCount;

public class RacingCar {
	public static void main(String[] args) {
		int carNumber = inputCarNumber().nextInt();
		int count = inputCount().nextInt();

		System.out.println("");
		System.out.println("실행 결과");

		Cars cars = new Cars();
		cars.setCars(carNumber);
		cars.viewPositionWithHyphen(carNumber);

		System.out.println("");

		for (int i = 0; i < count - 1; i++) {
			cars.moveCars();
			cars.viewPositionWithHyphen(carNumber);
			System.out.println("");
		}
	}
}
