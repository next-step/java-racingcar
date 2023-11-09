package camp.nextstep.edu.racingcar.view;

import java.util.Scanner;

public class RacingInputView {

    private static final Scanner sc = new Scanner(System.in);

    private RacingInputView() {

    }

    public static int readCarAmount(){
        System.out.println("자동차 대수는 몇 대 인가요?");
        return sc.nextInt();
    }

    public static int readRoundAmount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return sc.nextInt();
    }
}
