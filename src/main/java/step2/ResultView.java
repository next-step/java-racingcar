package step2;

public class ResultView {

	public static void printCars(Car[] cars) {
		for (Car car : cars) {
			printCar(car);
		}
		System.out.println();
	}

	private static void printCar(Car car) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0, len = car.getPosition(); i < len; i++) {
			sb.append("-");
		}
		System.out.println(sb.toString());
	}
}
