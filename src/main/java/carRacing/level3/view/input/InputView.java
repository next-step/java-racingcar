package carRacing.level3.view.input;

import carRacing.level3.infra.error.NameLengthException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

	private final Scanner scanner;
	private final String CAR_NAME_DELIMITER = ",";
	private final int MAX_LENGTH = 5;
	public static ArrayList<String> carNames = new ArrayList<>();

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

	private void validateLength(String carName) {
		if (carName.length() > MAX_LENGTH) {
			throw new NameLengthException("자동차 이름이 제한 길이를 초과하였습니다");
		}
	}

	public ArrayList<String> carNames() {
		return carNames;
	}

	public int carSum() {
		return carNames.size();
	}

	public List<String> saveCarNames() throws Exception {
		for (String carName : askCarsName()) {
			validateLength(carName);
			carNames.add(carName);
		}

		return carNames;
	}

}

