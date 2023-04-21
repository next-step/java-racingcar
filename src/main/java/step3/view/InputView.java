package step3.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String cars = scanner.nextLine();
        return checkInputCars(cars);
    }

    public int inputNumberOfMoves() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfMoves = scanner.nextInt();
        return checkInputNumber(numberOfMoves);
    }

    private int checkInputNumber(int numberOfMoves) {
        if (numberOfMoves <= 0) {
            throw new RuntimeException("입력값은 1 이상이어야 합니다.");
        }
        return numberOfMoves;
    }

    private String[] checkInputCars(String cars) {
        String[] carNames = cars.split(",");
        if (carNames.length == 0) {
            throw new IllegalArgumentException("입력된 자동차 이름이 없습니다.");
        }
        return carNames;
    }
}
