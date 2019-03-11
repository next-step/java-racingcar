package racing.service;

import racing.domain.Car;
import racing.domain.RacingCarRequest;

import java.util.List;
import java.util.Scanner;

public class RacingCarView {

    public static void startRacing(List<Car> cars, int round) {

        for (int i = 0; i < round; i++) {

            startRound(cars);

            System.out.println();

        }
    }

    public static void startRound(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + ": ");

            car.move();

            viewCarMoveInfo(car);

            System.out.println();
        }
    }

    public static void viewCarMoveInfo(Car car) {
        for (int i = 0; i < car.getTotalDistance(); i++) {
            System.out.print("-");
        }
    }

    public static void viewRacingCarWinners(List<Car> winners) {
        String winner = "";
        for (Car car : winners) {
            winner += car.getName() + ", ";
        }
        System.out.println(winner.substring(0, winner.length() - 2) + "가 최종 우승했습니다.");
    }

    public static RacingCarRequest getRacingCarRequest() {
        RacingCarRequest racingCarRequest = new RacingCarRequest();

        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        racingCarRequest.setNames(scanner.nextLine());
        System.out.println("시도할 회수는 몇 회 인가요?");
        racingCarRequest.setMoveCnt(Integer.parseInt(scanner.nextLine()));

        return racingCarRequest;
    }
}
