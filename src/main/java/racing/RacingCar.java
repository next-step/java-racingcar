package racing;

import racing.view.InputView;

import java.util.Scanner;

public class RacingCar {

	Scanner scanner = new Scanner(System.in);

	public void main() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		int playCarCount = scanner.nextInt();
		System.out.println(playCarCount);

		System.out.println("시도할 회수는 몇 회 인가요?");
		int playCount = scanner.nextInt();
		System.out.println(playCount);
		InputView inputView = new InputView(playCarCount, playCount);

	}
}
