package step3_racingcar.service;

public class CarStatus {

	public static String formatStatus(int position) {
		StringBuilder status = new StringBuilder();
		for (int i = 0; i < position; i++) {
			status.append("-");
		}
		return status.toString();
	}
}
