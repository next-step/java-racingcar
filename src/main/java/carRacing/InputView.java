package carRacing;

import java.util.Scanner;

public class InputView {

	private static final int MINIMUM_NATURAL_NUM = 1;
	private Scanner sc = new Scanner(System.in);

	public int inputCarCount() {
		return getValidCount("자동차 대수는 몇 대 인가요?");
	}

	public int inputMoveCount() {
		return getValidCount("시도할 회수는 몇 회 인가요?");
	}

	public int getValidCount(String text) {
		System.out.println(text);
		if (sc.nextInt() < MINIMUM_NATURAL_NUM){
			throw new IllegalArgumentException("1 이상의 자연수를 입력해주세요.");
		}
		return sc.nextInt();
	}
}
