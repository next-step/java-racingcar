package step3;

import java.util.Scanner;

public class Input {
    private final String CAR_CNT_MSG = "자동차 대수는 몇 대 인가요?";
    private final String TRY_CNT_MSG = "시도할 회수는 몇 회 인가요?";
    private Scanner scanner = new Scanner(System.in);

    public int readCarCount(){
        System.out.println(CAR_CNT_MSG);
        return scanner.nextInt();
    }

    public int readTryCnt(){
        System.out.println(TRY_CNT_MSG);
        return scanner.nextInt();
    }

}
