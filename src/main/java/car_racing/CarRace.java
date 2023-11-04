package car_racing;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class CarRace {
    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        Integer carCount = parseInt(scanner.nextLine());
        System.out.println("시도할 횟수는 몇 회 인가요?");
        Integer movingCount = parseInt(scanner.nextLine());
        Track track = new Track(carCount, movingCount);
        track.run();
    }
}
