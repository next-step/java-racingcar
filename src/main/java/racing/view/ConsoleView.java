package racing.view;

import racing.domain.Car;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {

    public static void viewCarMoveInfo(int moveDistance) {
        for (int i = 0; i < moveDistance; i++) {
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

    public static String[] getCarNames() throws RuntimeException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String[] names = CommonView.parseCarNames(scanner.nextLine());

        return names;
    }

    public static int getRoundCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇 회 인가요?");

        return Integer.parseInt(scanner.nextLine());
    }

    public static void viewRound(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + ": ");

            int moveDistance = car.getTotalDistance();

            viewCarMoveInfo(moveDistance);

            System.out.println();
        }

        System.out.println();
    }
}
