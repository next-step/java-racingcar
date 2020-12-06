package racing.view;

import java.util.Scanner;

public class InputView {
	private String inputName;
	private int playCount;
	private int playRacingCarCount;

	public InputView() {
	}

	public InputView(String inputName, int playRacingCarCount, int playCount) {
		this.inputName = inputName;
		this.playRacingCarCount = playRacingCarCount;
		this.playCount = playCount;
	}

	public String getInputName() {
		return inputName;
	}

	public int getPlayCount() {
		return playCount;
	}

	public int getPlayRacingCarCount() {
		return playRacingCarCount;
	}

}
