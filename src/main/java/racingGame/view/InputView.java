package racingGame.view;

import java.util.Scanner;

import racingGame.utils.StringUtils;

public class InputView {
	public static int inputCountOfCars(Scanner sc) {
		System.out.println("자동차의 대수는 몇 대 인가요?");
		return StringUtils.parseInt(sc.nextLine());
	}
	
	public static int inputCountOfTimes(Scanner sc) {
		System.out.println("시도할 횟수는 몇 회 인가요");
		return  StringUtils.parseInt(sc.nextLine());
	}
}
