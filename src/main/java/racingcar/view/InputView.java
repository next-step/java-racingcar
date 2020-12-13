package racingcar.view;

import racingcar.domain.Car;

import java.util.Scanner;

import static java.lang.System.out;

public class InputView {
    private static final String SPLIT_TEXT = ",";
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String[] inputNameOfCar() {
        out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carName = scanner.nextLine().split(SPLIT_TEXT);

        inputNameValid(carName);

        return carName;
    }

    public int inputCountOfPlay() {
        out.println("시도할 회수는 몇회인가요?");

        return scanner.nextInt();
    }

    public void inputNameValid(String[] names) {
        for (String carName : names) {
            if (carName.trim().length() == 0) {
                throw new IllegalArgumentException("이름을 입력해주세요.");
            }

            if (carName.length() > 5) {
                throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
            }
        }
    }
}
