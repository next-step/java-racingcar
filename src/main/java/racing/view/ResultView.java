package racing.view;

public class ResultView {

	public static final String FORWARD_MARKER = "-";

	public static final String CAR_NAME_MARKER = " : ";

	StringBuilder stringBuilder = new StringBuilder();

	public void print(String carName, int forwardResult) {
		stringBuilder.setLength(0);
		stringBuilder.append(carName).append(CAR_NAME_MARKER);
		for (int i = 0; i < forwardResult; i++) {
			stringBuilder.append(FORWARD_MARKER);
		}
		System.out.println(stringBuilder.toString());
	}

	public void printFinalWinner(String winnerName){
		System.out.println(winnerName + "가 최종 우승했습니다.");
	}
}
