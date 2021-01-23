package racingcar.view;

import java.util.ArrayList;
import java.util.Scanner;

public class InputHandler {

    private final Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 , 기준으로 구분)");
        return scanner.nextLine();
    }

    public int getLaps() {
        System.out.println("숫자 입력");
        return scanner.nextInt();
    }
}
