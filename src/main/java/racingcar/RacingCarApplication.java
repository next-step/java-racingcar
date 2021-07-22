package racingcar;

import java.util.Scanner;

public class RacingCarApplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView();

        inputView.numberOfCarQuestionShow();
        int numberOfCar = Integer.parseInt(scanner.nextLine());

        inputView.raceTrialCountQuestionShow();
        int raceTrialCount = Integer.parseInt(scanner.nextLine());

        RaceInfo raceInfo = new RaceInfo(numberOfCar, raceTrialCount);


    }
}
