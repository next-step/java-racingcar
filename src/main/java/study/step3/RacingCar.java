package study.step3;

import java.util.*;

public class RacingCar {

    public static void main(String[] args){
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("자동차 대수는 몇 대 인가요?");
            int carCount = scanner.nextInt();
            System.out.println("시도할 회수는 몇 회 인가요?");
            int tryRound = scanner.nextInt();

            executeRacingCar(carCount, tryRound);

        } catch(InputMismatchException exception) {
            throw new IllegalArgumentException("입력 문자열이 정상적이지 않습니다.");
        }
    }

    private static void executeRacingCar(int carCount, int tryRound) {
        SetUpCar setUpCar = new SetUpCar(carCount, tryRound);
//        setUpCar.tryRacing();
    }
}
