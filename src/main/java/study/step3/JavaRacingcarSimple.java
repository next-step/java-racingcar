package study.step3;

import java.util.Random;
import java.util.Scanner;

public class JavaRacingcarSimple {

	private static final int STANDARD = 4;

	public void printJavaRacingcarSimple() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("자동차 대수는 몇 대 인가요?");
		int value = scanner.nextInt();

		System.out.println("시도할 회수는 몇 회 인가요?");
		int number = scanner.nextInt();

		// Racingcar class 초기화
		Racingcar[] racingcars = new Racingcar[value];
		for (int i = 0; i < value; i++) {
			racingcars[i] = new Racingcar();
			racingcars[i].setInitScore();
		}

		System.out.println("실행 결과");
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < value; j++) {
				if (isGoForward(new Random().nextInt(10))) {
					racingcars[j].addScore();
				}
				printCurrentStatus(racingcars[j].getScore());
			}
			System.out.println();
		}

		scanner.close();
	}

	// random 값이 4이상인 경우 true 반환
	public boolean isGoForward(int random) {
		return random >= STANDARD;
	}

	// score 개수 만큼 "-" 출력
	public void printCurrentStatus(int score) {
		for (int i = 0; i < score; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
