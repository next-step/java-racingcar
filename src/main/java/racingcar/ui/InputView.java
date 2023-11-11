package racingcar.ui;

import java.util.Scanner;

public class InputView {

    public String[] inputCars() {
        System.out.println("경주할 자동차의 이름을 입력하세요(자동차의 이름마다 쉼표를 넣어주세요.)");
        Scanner scanner = new Scanner(System.in);
        String inputCars = scanner.nextLine();
        return extractCarNames((inputCars));
    }

    private String[] extractCarNames(String inputCar) {
        return inputCar.split(",");
    }

    public int inputGameTurn() {
        System.out.println("시도할 회수는 몇 회인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
