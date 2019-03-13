package racinggame;

import java.util.Scanner;

public class InputView {

    public static RacingGameConfiguration getConfiguration() {
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = sc.nextInt();
        sc.nextLine();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfTries = sc.nextInt();
        sc.nextLine();

        return new RacingGameConfiguration( numberOfCars, numberOfTries );
    }

}