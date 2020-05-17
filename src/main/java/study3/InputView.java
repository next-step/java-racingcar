package study3;

import java.util.Scanner;

/*
 *  생성자를 통해 Input UI 출력
 *  author : choi 
 */
public class InputView {
	RacingGame rg = new RacingGame();

	public InputView() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("자동차 대수는 몇 대 인가요?");
		int value = scanner.nextInt();

		System.out.println("시도할 횟수는 몇 회 인가요?");
		int number = scanner.nextInt();

		System.out.println("실행 결과");

		rg.move(value, number); // 자동차개수, 시도할 횟수전달
	}

}
