package study;

import java.util.Scanner;

public class InputView {

    private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final Scanner sc = new Scanner(System.in);

    private InputView(){

    }

    public String carName() {
        System.out.println(CAR_NAME_MESSAGE);
        return sc.nextLine();
    }

    public int tryCount(){
        System.out.println(TRY_COUNT_MESSAGE);
        return sc.nextInt();
    }

}
