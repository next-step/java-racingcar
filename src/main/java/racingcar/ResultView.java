package racingcar;

public class ResultView {
	public static void result(final int carNumber, final int count) {

		lineBreaking();
		System.out.println("실행 결과");

		Cars cars = new Cars();
		cars.setCars(carNumber);
		cars.viewPositionWithHyphen(carNumber);

		lineBreaking();

		viewPositionWithHyphenAfter2nd(carNumber, count, cars);
	}

	private static void viewPositionWithHyphenAfter2nd(final int carNumber, final int count, final Cars cars) {
		for (int i = 0; i < count - 1; i++) {
			cars.moveCars();
			cars.viewPositionWithHyphen(carNumber);
			lineBreaking();
		}
	}

	private static void lineBreaking() {
		System.out.println("");
	}
}
