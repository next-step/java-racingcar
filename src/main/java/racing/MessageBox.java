package racing;

public class MessageBox {

	private static final String FIRST_REQUEST = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String SECOND_REQUEST = "시도할 회수는 몇회인가요?";
	private static final String RESULT_MESSAGE = "실행_결과";
	private static final String WINNER_MESSAGE = " 가 최종 우승했습니다.";

	public void firstRequestMessage() {
		System.out.println(FIRST_REQUEST);
	}

	public void secondRequestMessage() {
		System.out.println(SECOND_REQUEST);
	}

	public void resultMessage() {
		System.out.println(RESULT_MESSAGE);
	}

	public void winnerMessageBox(String winner) {
		System.out.println(winner + WINNER_MESSAGE);
	}

	public void commonMessageBox(String message) {
		System.out.println(message);
	}

	public void racingResultMessage(String playerName, String racingResult) {
		commonMessageBox(playerName + racingResult);
	}

}
