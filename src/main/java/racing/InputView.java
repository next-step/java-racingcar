package racing;

import java.util.Scanner;

public class InputView {

    public static Race createRace() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner carScanner = new Scanner(System.in);
        int numberOfCars = carScanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        Scanner playScanner = new Scanner(System.in);
        int numberOfPlays = playScanner.nextInt();

        return new Race(numberOfCars, numberOfPlays);
    }
}
