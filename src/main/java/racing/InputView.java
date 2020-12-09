package racing;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class InputView {

	private final Scanner scanner = new Scanner(System.in);

	List<String> inputCarNameList() {
		String carNameInput;
		do {
			System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
			carNameInput = scanner.next();
		} while (!validateCarNameInput(carNameInput));
		return Arrays.asList(carNameInput.split(","));
	}

	private boolean validateCarNameInput(String carNameInput) {
		List<String> carNameList = Arrays.asList(carNameInput.split(","));
		try {
			carNameList.forEach(this::isValidateCarName);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private void isValidateCarName(String carName) throws IllegalArgumentException {
		if (carName.length() > 5) {
			throw new IllegalArgumentException("차 이름은 무조건 5자 이하여야 합니다");
		}

		if (carName.length() == 0) {
			throw new IllegalArgumentException("차 이름이 비어있으면 안됩니다.");
		}

		if (carName.contains(" ")) {
			throw new IllegalArgumentException("차 이름에 공백이 들어가서는 안됩니다");
		}
	}

	int inputRaceTurn() {
		System.out.println("시도할 회 수는 몇 회 인가요?");
		return scanner.nextInt();
	}
}
