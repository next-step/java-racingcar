package carRace.step5.controller;


import carRace.step5.domain.CarRacingGame;

public class CarRaceGameController {
    public void gameStart(String[] carNames, int raceTryCount) {
        CarRacingGame carRacingGame = new CarRacingGame(carNames, raceTryCount);
        carRacingGame.playRacingGame();
        carRacingGame.drawRasingGame();
        carRacingGame.drawRasingWinner();
    }
}
