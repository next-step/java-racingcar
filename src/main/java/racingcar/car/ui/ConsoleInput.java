package racingcar.car.ui;

import java.util.Scanner;

public class ConsoleInput {

    private final Scanner scanner = new Scanner(System.in);

    public String[] split(final String inputText) {
        return inputText.split(",");
    }

    public String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return split(scanner.nextLine());
    }

    public int getPlayCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scanner.nextInt();
    }
}
