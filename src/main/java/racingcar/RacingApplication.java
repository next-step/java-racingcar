package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import common.NumberGenerator;
import common.RandomNumberGenerator;

public class RacingApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        int n = scanner.nextInt();

        List<Vehicle> participateCar = getParticipateCar(n);
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        Game game = new RacingGame(participateCar, numberGenerator);

        System.out.println("시도할 회수는 몇 회 인가요?");
        int round = scanner.nextInt();

        Game gameRunner = new GameRunner(game);
        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            gameRunner.start();
        }

    }

    private static List<Vehicle> getParticipateCar(int n) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            vehicles.add(new Car());
        }
        return vehicles;
    }
}
