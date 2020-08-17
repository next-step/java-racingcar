package racing.ui;

import java.util.Scanner;

public class InputView {

    private static final String DELIMETER = ",";
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String[] getNamesOfCars() {
        return getArraysOfString("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public int getNumberOfTrials() {
        return getNumber("시도할 회수는 몇 회 인가요?");
    }

    private int getNumber(String s) {
        System.out.println(s);
        return scanner.nextInt();
    }

    private String[] getArraysOfString(String s) {
        System.out.println(s);
        return scanner.nextLine().split(DELIMETER);
    }
}
