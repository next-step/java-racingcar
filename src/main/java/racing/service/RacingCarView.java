package racing.service;

import racing.domain.Car;
import racing.domain.RacingCarRequest;

import java.util.List;
import java.util.Scanner;

public class RacingCarView {

    public static void viewRacingCar(List<Car> cars, int moveCnt) {

        for (int i = 0; i < moveCnt; i++) {

            for (int j = 0; j < cars.size(); j++) {

                System.out.print(cars.get(j).getName() + ": ");

                for (int k = 0; k < i + 1; k++) {
                    if (cars.get(j).getMoveList().get(k) == 1) {
                        System.out.print("-");
                    }
                }

                System.out.println();
            }

            System.out.println();

        }
    }

    public static void viewRacingCarWinners(List<Car> cars) {
        String winners = "";
        for (Car car : cars) {
            winners += car.getName() + ", ";
        }
        System.out.println(winners.substring(0, winners.length() - 2) + "가 최종 우승했습니다.");
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
