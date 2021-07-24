package racing;

public class MessageBox {

	public void commonMessageBox(String message) {
		System.out.println(message);
	}

	public void racingResultMessage(String playerName, int racingResult) {
		String result = stringBufferToString(getRacingResultByString(racingResult));
		commonMessageBox(playerName + result);
	}

	private StringBuffer getRacingResultByString(int racingResult) {
		StringBuffer result = new StringBuffer(racingResult);
		for (int i = 0; i < racingResult; i++) {
			result.append("-");
		}
		return result;
	}

	private String stringBufferToString(StringBuffer stringBufferValue) {
		return stringBufferValue.toString();
	}

	public void commonMessageBox(String winPlayers, String winner_message) {
		commonMessageBox(winPlayers + winner_message);
	}
}
