package study.step5.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import study.step5.exception.BadRequestException;

public class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String SEPARATOR = ",";			// 이름 구분자
	private static final int MAX_NAME_LENGTH = 5;		// 입력할 수 있는 최대 글자수

	public List<String> getNames() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		String input = SCANNER.next();
		List<String> names = Arrays.asList(input.split(SEPARATOR));

		names.forEach(this::validateName);

		return names;
	}

	public int getRound() {
		System.out.println("시도할 회수는 몇회인가요?");
		int round = SCANNER.nextInt();

		validateRound(round);

		return round;
	}

	public void validateName(String name) {
		if (name.length() > MAX_NAME_LENGTH) {
			throw new BadRequestException("이름은 5글자를 초과할 수 없습니다.");
		}
	}

	public void validateRound(int round) {
		if (round < 0) {
			throw new BadRequestException("음수는 입력할 수 없습니다.");
		}
	}
}
