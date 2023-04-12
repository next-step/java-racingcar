package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutoRacing {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void startRacing() {
        InputView.guidForInputNumberOfCar();
        int numberOfCar = SCANNER.nextInt();
        InputView.guideForInputNumberOfGame();
        int numberOfGame = SCANNER.nextInt();

        AutoRacingParticipant autoRacingParticipant = new AutoRacingParticipant();
        autoRacingParticipant.participateGame(createCar(numberOfCar));

        autoRacingParticipant.doGame(numberOfGame);
    }

    private static List<RacingCar> createCar(int numberOfCar) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            RacingCar racingCar = new RacingCar();
            racingCarList.add(racingCar);
        }
        return racingCarList;
    }

}
