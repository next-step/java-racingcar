package racingGame.ui;

public class ResultView {
	private static String RESULT_MSG = "실행 결과";

	public void printResultStart(){
		System.out.println(RESULT_MSG);
	}

	public void printResult(int[] cars) {
		for (int i = 0; i < cars.length; i++) {
			System.out.println(getCarMarkerString(cars[i]));
		}
	}

	private String getCarMarkerString(int car) {
		StringBuilder carMarker = new StringBuilder();
		for (int j = 0; j < car; j++) {
			carMarker.append("-");
		}
		return carMarker.toString();
	}
}
