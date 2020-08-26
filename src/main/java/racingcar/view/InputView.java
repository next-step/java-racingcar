package racingcar.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public String viewNumberOfCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String carNames = scanner.nextLine();
        isEmpty(carNames);

        return carNames;
    }

    public int viewNumberOfTry() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return isNumber(scanner.nextLine());
    }

    private void isEmpty(String input) {
        if(input == null || input.trim().equals("")) {
            throw new IllegalArgumentException("빈 값이 들어올 수 없습니다.");
        }
    }

    private int isNumber(String input) {
        try {
            isEmpty(input);
            return Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new NumberFormatException();
        }
    }
}
