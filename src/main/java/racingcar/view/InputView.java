package racingcar.view;

import racingcar.util.Console;

public class InputView {

    private InputView() {
    }

    public static String getCarNames() {
        String input = "";
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        try {
            input = Console.readLine();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        return input;
    }

    public static int gettryNo() {
        String input = "";
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            input = Console.readLine();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        return Integer.parseInt(input);
    }
}
