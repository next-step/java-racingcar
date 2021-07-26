package racing.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

import racing.domain.Car;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	private InputView() {

	}

	public static String[] inputCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

		String input = scanner.nextLine();
		String[] names = input.split(",");

		return Arrays.stream(names)
			.filter(Car::validate)
			.toArray(String[]::new);
	}

	public static int inputTryCount() {
		System.out.println("시도할 회수는 몇 회 인가요?");

		return scanner.nextInt();
	}
}
