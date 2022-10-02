package study.step3;

import java.util.Random;
import java.util.Scanner;

public class JavaRacingcarSimple {

	private static final int STANDARD = 4;

	public static void main(String[] args) {
		printJavaRacingcarSimple();
	}

	public static void printJavaRacingcarSimple() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("자동차 대수는 몇 대 인가요?");
		int number = scanner.nextInt();

		System.out.println("시도할 회수는 몇 회 인가요?");
		int count = scanner.nextInt();

		Racingcar[] racingcars = initRacingCars(number);

		System.out.println("실행 결과");
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < number; j++) {
				proceedJavaRacingcarSimple(racingcars[j]);
			}
			System.out.println();
		}

		scanner.close();
	}

	// Racingcar class 초기화
	public static Racingcar[] initRacingCars(int number) {
		Racingcar[] racingcars = new Racingcar[number];
		for (int i = 0; i < number; i++) {
			racingcars[i] = new Racingcar();
			racingcars[i].setInitScore();
		}
		return racingcars;
	}

	// 초간단 자동차 경주 게임 진행
	public static void proceedJavaRacingcarSimple(Racingcar racingcar) {
		if (isGoForward(new Random().nextInt(10))) {
			racingcar.addScore();
		}
		printCurrentStatus(racingcar.getScore());
	}

	// random 값이 4이상인 경우 true 반환
	public static boolean isGoForward(int random) {
		return random >= STANDARD;
	}

	// score 개수 만큼 "-" 출력
	public static void printCurrentStatus(int score) {
		for (int i = 0; i < score; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
