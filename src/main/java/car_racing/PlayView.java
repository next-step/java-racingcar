package car_racing;

import java.util.Scanner;

public class PlayView {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요 ?");
        int numberOfCar = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfRound = scanner.nextInt();

        CarRacingGame carRacing = new CarRacingGame(numberOfCar, numberOfRound);
        String result = carRacing.play();

        System.out.println("\n실행 결과");
        System.out.println(result);
    }
}
