package racingcar.view;

import java.util.Scanner;

public class InputView {

    public static int showCarCountInput() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
