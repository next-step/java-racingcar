package step3;

public class OutputView {
	private static final String MOVE_OUTPUT = "-";

	public void viewCarState(Car car) {
		int position = car.getPosition();

		for (int i = 0; i < position; i++) {
			System.out.print(MOVE_OUTPUT);
		}
		System.out.println();
	}

	public void viewEndTrial() {
		System.out.println();
	}
}
