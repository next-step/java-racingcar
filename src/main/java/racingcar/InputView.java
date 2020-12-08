package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);
	private static final String NAME_SEPARATOR = ",";

	public static List<String> totalCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		String carNames = scanner.nextLine();
		return Arrays.asList(carNames.split(NAME_SEPARATOR));
	}

	public static int totalTryCount() {
		System.out.println("시도할 횟수는 몇 회 인가요?");
		return scanner.nextInt();
	}
}
