package carRacing.level3.view.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

	private final Scanner scanner;
	private final String CAR_NAME_DELIMITER = ",";
	private final ArrayList<String> carNames = new ArrayList<>();

	public InputView() {
		scanner = new Scanner(System.in);
	}

	public int askValueRound() {
		System.out.println("시도 회수는 몇회인가요?");
		return scanner.nextInt();
	}

	public String[] askCarsName() {
		System.out.println("경주할 자동차 이름을 입력하세요");
		return scanner.nextLine().split(CAR_NAME_DELIMITER);

	}

	public List<String> saveCarNames() {
		for (String carName : askCarsName()) {
			carNames.add(carName);
		}
		return carNames;
	}

}

