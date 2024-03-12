package racingcar;

public class ResultView {
	private static final char POSITION_CHAR_CODE = '-';

	public static void result(final String[] carNames, final int count) {

		lineBreaking();
		System.out.println("실행 결과");

		Cars cars = Cars.createCars(carNames);

		viewCarPositions(cars, count, POSITION_CHAR_CODE);
	}

	private static void viewCarPositions(final Cars cars, final int count, final char positionChar) {
		for (int i = 0; i < count; i++) {
			moveCars(cars, count);
			printPositions(cars, positionChar);
			lineBreaking();
		}
	}

	private static void printPositions(final Cars cars, final char positionChar) {
		for (int j = 0; j < cars.getSize(); j++) {
			System.out.println(carNameAndPositionWithChar(cars.getCars().get(j), positionChar));
		}
	}

	private static void moveCars(final Cars cars, final int count) {
		if (count != 0) {
			cars.moveCars();
		}
	}

	private static void lineBreaking() {
		System.out.println("");
	}

	public static String carNameAndPositionWithChar(final Car car, final char positionChar) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < car.getPosition(); i++) {
			sb.append(positionChar);
		}
		return car.getName() + " : " + sb.toString();
	}
}
