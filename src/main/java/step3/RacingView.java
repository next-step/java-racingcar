package step3;

import step3.race.Race;

import java.util.Scanner;

public class RacingView {
    static int carCounts = 0, raceTimes = 0;

    public static void main(String[] args) {

        inputParameter();
        doRace();
    }

    private static void inputParameter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        carCounts = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        raceTimes = scanner.nextInt();
    }

    private static void doRace() {
        Race race = new Race(carCounts);

        for (int i = 0; i < raceTimes; i++) {
            race.racing();
        }
    }

}
