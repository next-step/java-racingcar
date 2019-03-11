package racing;

import java.util.List;
import java.util.Scanner;

public class RacingCar {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String text = scanner.nextLine();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int moveCnt = Integer.parseInt(scanner.nextLine());

        doRacing(text, moveCnt);

    }

    private static void doRacing(String text, int moveCnt) {

        try {
            String[] names = RacingCarMake.parseCarNames(text);

            List<Car> cars = RacingCarMake.getCars(names);

            RacingCarMake.moveCars(cars, moveCnt);

            RacingCarView.viewRacingCar(cars, moveCnt);

            RacingCarRank.sortCars(cars);

            List<Car> winners = RacingCarRank.rankCars(cars);

            RacingCarView.viewRacingCarWinners(winners);

        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
    }


}
