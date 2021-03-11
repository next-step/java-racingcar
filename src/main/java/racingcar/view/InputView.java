package racingcar.view;

import racingcar.domain.Car;
import racingcar.dto.InputManagement;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);
    private static final String SEPARATOR = ",";

    public String[] inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        System.out.println("<주의> 자동차 이름은 5자를 초과할 수 없습니다.");

        return scanner.nextLine().split(SEPARATOR);
    }

    public int inputCountRound() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public void isInValidNames(String[] carNames) {
        for (String carName : carNames) {
            new Car(carName, 0).nameValueInValidation();
        }
    }

    public InputManagement input() {
        String[] carNames;

        carNames = inputNames();
        isInValidNames(carNames);

        return new InputManagement(carNames, inputCountRound());
    }
}
