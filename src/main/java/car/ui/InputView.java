package car.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

	private static final String CAR_COUNT_TEXT = "자동차의 대수는 몇 대 인가요?";
	private static final String TRY_COUNT_TEXT = "시도할 회수는 몇 회 인가요?";
	private static final Scanner SCANNER = new Scanner(System.in);

	public static int carCount;
	public static int tryCount;

	public static void input() {
		try {
			System.out.println(CAR_COUNT_TEXT);
			carCount = SCANNER.nextInt();
			System.out.println(TRY_COUNT_TEXT);
			tryCount = SCANNER.nextInt();
		} catch (InputMismatchException ime) {
			System.out.println("입력값이 올바르지 않습니다. 다시 시도하세요.");
		}
	}
}
