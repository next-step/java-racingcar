package study;

import java.util.List;
import java.util.Scanner;

public class ResultView {
    public static void main(String[] args) {

        startRacing();
    }


    public static void startRacing() {
        RacingService racingService = new RacingService();
        Scanner scan = new Scanner(System.in);

        System.out.println("자동차의 대수는 몇 대 인가요?");
        int carQuantity = scan.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = scan.nextInt();

        System.out.println("실행 결과");
        List<RacingCar> racingCars = racingService.createRacingCars(carQuantity);

        racingService.startRacingGame(tryCount, racingCars);
    }
}
