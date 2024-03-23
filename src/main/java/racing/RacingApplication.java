package racing;

import racing.domain.Cars;
import racing.service.Race;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.Scanner;

public class RacingApplication {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        InputView.printCarNameRequest();
        String carNamesString = scan.nextLine();

        InputView.printTrialRequest();
        int trials = scan.nextInt();
        Cars cars = new Cars(carNamesString);
        Race race = new Race(cars);
        // 게임 진행
        for (int turn = 0; turn < trials; turn++) {
            race.startMoving();
            ResultView.printCars(race.getCars());
        }
        ResultView.printWinners(race.getWinners());
    }
}
