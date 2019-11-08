package step2;

public class ResultView {

	public void printCars(int[] carPositions) {
		for (int i = 0; i < carPositions.length; i++) {
			printCar(carPositions[i]);
		}
		System.out.println();
	}

	private void printCar(int carPosition) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < carPosition; i++) {
			sb.append("-");
		}
		System.out.println(sb.toString());
	}
}
