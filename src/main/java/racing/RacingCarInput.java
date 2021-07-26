package racing;

import java.util.Scanner;

public class RacingCarInput {
    static int numOfCar;
    static int numOfCycle;
    public int[] requestInput() {
        Scanner sc = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        numOfCar = sc.nextInt();
        RacingCarEnumInputCheck.valueOf("NUM_OF_CAR").validInputCheck(numOfCar);

        System.out.println("시도할 회수는 몇 회 인가요?");
        numOfCycle = sc.nextInt();
        RacingCarEnumInputCheck.valueOf("CYCLE_OF_RACING").validInputCheck(numOfCycle);

        return new int[] {numOfCar, numOfCycle};
    }
}
