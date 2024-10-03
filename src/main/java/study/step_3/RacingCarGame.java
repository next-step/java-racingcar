package study.step_3;

import study.step_3.service.RacingCar;
import study.step_3.ui.UiController;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private final UiController uiController;

    public RacingCarGame(UiController uiController) {
        this.uiController = uiController;
    }

    public List<RacingCar> setUpRacingCar(int numberOfCars) {
        ArrayList<RacingCar> garage = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            garage.add(new RacingCar());
        }
        return garage;
    }

    public void gamePlay() {
        int numberOfCars = uiController.welcomeMessage();
        int attempt = uiController.askAttemptMessage();
        List<RacingCar> garage = setUpRacingCar(numberOfCars);
        startGame(attempt, numberOfCars, garage);
    }

    private void startGame(int attempt, int numberOfCars, List<RacingCar> garage) {
        uiController.endGameMessage();

        for (int i = 0; i < attempt; i++) {
            startRacing(numberOfCars, garage);
            System.out.println();
        }
    }

    private void startRacing(int numberOfCars, List<RacingCar> garage) {
        for (int j = 0; j < numberOfCars; j++) {
            racingCarMoving(garage, j);
        }
    }

    private void racingCarMoving(List<RacingCar> garage, int numberOfCar) {
        int distance = garage.get(numberOfCar).drive(10, 4);

        if ((distance > 0)) {
            uiController.SkidMark(distance);
        }

        uiController.cantDrive(distance);
    }

    public static void main(String[] args) {
        RacingCarGame game = new RacingCarGame(new UiController());
        game.gamePlay();
    }
}
