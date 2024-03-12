package racingcar.ui;

import java.util.Scanner;

public class InputView {

    private final static Scanner SCANNER = new Scanner(System.in);

    public String readCarNameString() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return readString();
    }

    public int readHowManyTrys() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return readInt();
    }

    private String readString() { return SCANNER.nextLine(); }

    private int readInt() {
        return SCANNER.nextInt();
    }

}
