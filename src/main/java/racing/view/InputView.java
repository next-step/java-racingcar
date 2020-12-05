package racing.view;

import java.util.Scanner;

public class InputView {
	private int playCount;
	private int playRacingCarCount;

	public InputView() {
	}

	public InputView(int playRacingCarCount, int playCount) {
		this.playRacingCarCount = playRacingCarCount;
		this.playCount = playCount;
	}

	public int getPlayCount() {
		return playCount;
	}

	public int getPlayRacingCarCount() {
		return playRacingCarCount;
	}

}
