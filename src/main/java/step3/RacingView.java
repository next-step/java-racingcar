package step3;

import java.util.Scanner;

public class RacingView {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//          자동차 대수는 몇 대 인가요?
//          3
//          시도할 회수는 몇 회 인가요?
//          5
//          실행 결과
        int carCounts = 0, raceTimes = 0;
        System.out.println("자동차 대수는 몇 대 인가요?");
        carCounts = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        raceTimes = scanner.nextInt();

        Race race = new Race(carCounts);

        for (int i = 0; i < raceTimes; i++) {
            race.racing();

        }
    }
}
