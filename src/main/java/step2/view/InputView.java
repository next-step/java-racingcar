package step2.view;

import java.util.Scanner;

public class InputView {
	enum InputType {
		CAR_NUM("자동차 대수는 몇 대 인가요?"),
		TRY_NUM("시도할 횟수는 몇 회 인가요?");

		private String msg;

		InputType(String msg) {
			this.msg = msg;
		}

		public String getMsg() {
			return msg;
		}
	}

	// 차량 수 입력 받음
	public int getCarNum() {
		return getInput(InputType.CAR_NUM);
	}

	// 횟수 입력 받음
	public int getTryNum() {
		return getInput(InputType.TRY_NUM);
	}

	private int getInput(InputType inputType) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(inputType.getMsg());
		int value;
		try {
			value = Integer.parseInt(scanner.nextLine());
		} catch (Exception e) {
			System.out.println("숫자를 입력해주세요.");
			return getInput(inputType);
		}

		if(value < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
			return getInput(inputType);
		}

		return value;
	}
}
