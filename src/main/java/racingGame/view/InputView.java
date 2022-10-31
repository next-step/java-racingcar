package study;

import java.util.Scanner;

public class InputView {

    private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final Scanner sc = new Scanner(System.in);

    private InputView(){

    }

    public static String carNames() {
        System.out.println(CAR_NAME_MESSAGE);
        return sc.nextLine();
    }

    public static int tryCount(){
        System.out.println(TRY_COUNT_MESSAGE);
        return sc.nextInt();
    }

}
