package racingcar;

public class ResultView {
	private static final char POSITION_CHAR_CODE = '-';

	public static void result(final int carNumber, final int count) {

		lineBreaking();
		System.out.println("실행 결과");

		Cars cars = new Cars();
		cars.setCars(carNumber);

		viewCarPositions(cars, POSITION_CHAR_CODE);

		lineBreaking();

		viewPositionAfter2nd(count, cars);
	}

	private static void viewPositionAfter2nd(final int count, final Cars cars) {
		for (int i = 0; i < count - 1; i++) {
			cars.moveCars();
			viewCarPositions(cars, POSITION_CHAR_CODE);
			lineBreaking();
		}
	}

	private static void lineBreaking() {
		System.out.println("");
	}

	private static void viewCarPositions(final Cars cars, final char positionChar) {
		for (int i = 0; i < cars.getCars().size(); i++) {
			System.out.println(carPositionWithChar(cars.getCars().get(i),positionChar));
		}
	}

	private static String carPositionWithChar(final Car car, final char positionChar) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < car.getPosition(); i++) {
			sb.append(positionChar);
		}
		return sb.toString();
	}
}
