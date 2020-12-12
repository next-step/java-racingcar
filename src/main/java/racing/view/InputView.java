package racing.view;

import racing.car.CarName;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

	private static final String CAR_NAME_SPLITTER = ",";

	private final Scanner scanner = new Scanner(System.in);

	public List<CarName> inputCarNameList() {
		String carNameInput;
		do {
			System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
			carNameInput = this.scanner.next();
		} while (!validateCarNameInput(carNameInput));
		return createCarNameList(carNameInput);
	}

	private boolean validateCarNameInput(String carNameInput) {
		List<String> carNameList = Arrays.asList(carNameInput.split(CAR_NAME_SPLITTER));
		try {
			carNameList.forEach(CarName::validation);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	private List<CarName> createCarNameList(String carNameInput) {
		return Stream.of(carNameInput.split(CAR_NAME_SPLITTER))
				.map(CarName::new)
				.collect(Collectors.toList());
	}

	public int inputRaceTurn() {
		System.out.println("시도할 회 수는 몇 회 인가요?");
		return this.scanner.nextInt();
	}
}
