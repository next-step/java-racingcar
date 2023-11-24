package motorRace;

import java.util.Scanner;

public class InputView {

    private static final String CAR_CNT_INPUT_MSG = "자동차 대수는 몇 대 인가요?";
    private static final String MOVE_CNT_INPUT_MSG = "시도할 회수는 몇 회 인가요?";

    public static int carCntIn(){
        System.out.println(CAR_CNT_INPUT_MSG);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int moveCntIn(){
        System.out.println(MOVE_CNT_INPUT_MSG);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
