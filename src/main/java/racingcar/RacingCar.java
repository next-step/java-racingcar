package racingcar;

public class RacingCar {
	public static void run() {
		int carCount = InputView.totalCarCount();
		Cars cars = new Cars(carCount);

		int tryCount = InputView.totalTryCount();
		System.out.println("실행결과");
		for (int i = 0; i < tryCount; i++) {
			cars.move();
			System.out.println();
		}
	}
}
