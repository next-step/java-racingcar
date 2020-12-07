package racingCar;

import java.util.Scanner;

/**
 * @author : byungkyu
 * @date : 2020/12/07
 * @description :
 **/
public class View {
	private static final Scanner scanner = new Scanner(System.in);

	public static int inputCarCount() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		return scanner.nextInt();
	}

	public static int inputMatchCount() {
		System.out.println("시도할 회수는 몇 회 인가요?");
		return scanner.nextInt();
	}
}
