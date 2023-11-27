package race.view;

import java.util.Scanner;

public class InputView {

    public InputView() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("자동차 대수 : ");
        int numberOfCars = scanner.nextInt();
        System.out.print("시도할 횟수 : ");
        int numberOfTry = scanner.nextInt();
    }
}
