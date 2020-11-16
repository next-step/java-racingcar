package carRace.step5.controller;


import carRace.step5.domain.CarRacingGame;
import carRace.step5.domain.util.CarNamesCheck;
import carRace.step5.domain.util.TryCountCheck;
import carRace.step5.view.RaceInputView;

public class CarRaceGameController {

    public static void main(String[] args) {
        String[] carNames = CarNamesCheck.checkCarNames(RaceInputView.inputRaceNames());
        int raceTryCount = TryCountCheck.checkNumberValue(RaceInputView.inputTryCount());

        CarRacingGame carRacingGame = new CarRacingGame(raceTryCount, carNames);
        carRacingGame.RunPlayGame();
    }
}
