package step3.view;

public class OutputView {
	private static final String MOVE_OUTPUT = "-";

	public static void viewResult(int[][] result) {
		for (int i = 0; i < result.length; i++) {
			viewOneTrial(result[i]);
			System.out.println();
		}
	}

	private static void viewOneTrial(int[] cars) {
		for (int i = 0; i < cars.length; i++) {
			viewOneCar(cars[i]);
		}
	}

	private static void viewOneCar(int position) {
		for (int i = 0; i < position; i++) {
			System.out.print(MOVE_OUTPUT);
		}
		System.out.println();
	}
}