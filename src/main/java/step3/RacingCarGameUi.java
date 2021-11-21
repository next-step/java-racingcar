package step3;

import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class RacingCarGameUi {
    String BAR = "-";
    Scanner scanner;

    public RacingCarGameUi() {
        scanner = new Scanner(System.in);
    }

    public int askRacingCarNumber() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public int askAttemptNumber() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public void printResult(List<RacingCar> racingCarList) {
        System.out.println("실행 결과");
        Iterator iterator = racingCarList.iterator();
        while(iterator.hasNext()) {
            RacingCar racingCar = (RacingCar) iterator.next();
            printRacingCarDistance(racingCar.getDistance());
        }
    }

    public void printRacingCarDistance(int distance) {
        while(distance > 0) {
            System.out.print(BAR);
            distance--;
        }
        System.out.println("");
    }
}
