package racing;

import java.util.Scanner;

public class RacingCarInput {
    public void requestInput() throws IllegalArgumentException{
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        RacingCarEnumInputCheck.valueOf("NUM_OF_CAR").validInputCheck(sc.nextInt());
        System.out.println("시도할 회수는 몇 회 인가요?");
        RacingCarEnumInputCheck.valueOf("CYCLE_OF_RACING").validInputCheck(sc.nextInt());
    }
}
