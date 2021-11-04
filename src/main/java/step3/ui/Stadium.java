package step3.ui;

import step3.application.Engineer;
import step3.application.RacingTrack;
import step3.domain.car.Car;

import java.util.List;
import java.util.Scanner;

public class Stadium {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Long carCount = Long.parseLong(SCANNER.nextLine());

        System.out.println("시도할 회수는 몇 회 인가요?");
        Long goCount = Long.parseLong(SCANNER.nextLine());

        List<Car> cars = Engineer.makeCar(carCount, goCount);
        RacingTrack.showRacing(cars);
    }
}
