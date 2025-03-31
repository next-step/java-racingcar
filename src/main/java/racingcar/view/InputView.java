package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final String NAME_DELIMITER = ",";

    public String[] readNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input.split(NAME_DELIMITER);
    }

    public int putCoins() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
