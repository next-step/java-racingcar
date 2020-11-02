package car_racing;

import java.util.Scanner;

public class InputView {

    public void execute(CarRacingViewController viewController) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?\n");
        int numOfCar = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?\n");
        int tryCount = scanner.nextInt();

        viewController.input(numOfCar, tryCount);
    }
}
