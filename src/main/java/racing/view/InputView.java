package racing.view;

import java.util.Scanner;

public class InputView {
	Scanner scanner = new Scanner(System.in);

	private int playCount;
	private int playCarCount;

	public InputView() {
	}

	public int getPlayCount() {
		return playCount;
	}

	private void setPlayCount(int playCount) {
		this.playCount = playCount;
	}

	public int getPlayCarCount() {
		return playCarCount;
	}

	private void setPlayCarCount(int playCarCount) {
		this.playCarCount = playCarCount;
	}

	public void inputUI() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		int playCarCount = scanner.nextInt();
		System.out.println(playCarCount);
		this.setPlayCarCount(playCarCount);

		System.out.println("시도할 회수는 몇 회 인가요?");
		int playCount = scanner.nextInt();
		System.out.println(playCount);
		this.setPlayCount(playCount);
	}
}
