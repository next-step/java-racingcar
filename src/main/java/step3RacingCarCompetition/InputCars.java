package step3RacingCarCompetition;

import java.util.Scanner;

public class InputCars {

    public static Integer numberOfCars(Scanner scanner) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

}
