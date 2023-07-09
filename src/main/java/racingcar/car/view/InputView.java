package racingcar.car.view;

import java.util.Scanner;

public final class InputView {

    private static final String INPUT_SPLIT_REGEX = ",";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return split(scanner.nextLine());
    }

    public static int getPlayCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scanner.nextInt();
    }

    private static String[] split(final String inputText) {
        return inputText.split(INPUT_SPLIT_REGEX);
    }
}
