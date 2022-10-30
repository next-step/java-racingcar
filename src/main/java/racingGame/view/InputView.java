package study;

import java.util.Scanner;

public class InputView {

    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    Scanner sc = new Scanner(System.in);

    public String carName() {
        System.out.println(CAR_NAME_MESSAGE);
        return sc.nextLine();
    }

    public int tryCount(){
        System.out.println(TRY_COUNT_MESSAGE);
        return sc.nextInt();
    }
}
