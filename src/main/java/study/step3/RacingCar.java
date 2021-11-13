package study.step3;

import java.util.*;

public class RacingCar {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        String carCount = scanner.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        String tryCount = scanner.nextLine();

        executeRacingCar(carCount, tryCount);
    }

    public static boolean executeRacingCar(String carCount, String tryCount) {
        SetUpCar setUpCar = new SetUpCar(carCount, tryCount);
        return setUpCar.tryRacing();
    }
}
