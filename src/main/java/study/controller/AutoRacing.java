package study.controller;

import study.utils.CarFactory;
import study.domain.AutoRacingParticipant;
import study.domain.GameInfo;
import study.domain.RacingCar;
import study.view.InputView;
import study.view.ResultView;

import java.util.List;

public class AutoRacing {

    public static void main(String[] args) {
        startRacing();
    }

    public static void startRacing() {

        GameInfo gameInfo = InputView.prepareGame();

        AutoRacingParticipant autoRacingParticipant = new AutoRacingParticipant();

        ResultView.printBeforeGameStart();

        CarFactory carFactory = CarFactory.getInstance();

        List<RacingCar> racingCarList = carFactory.createCar(gameInfo.getNameList());

        autoRacingParticipant.participateGame(racingCarList);

        gameForGivenRound(gameInfo.getNumberOfGame(), autoRacingParticipant);

        ResultView.printName(autoRacingParticipant.getAllMaxMoveCountName());

    }

    private static void gameForGivenRound(int numberOfGame, AutoRacingParticipant autoRacingParticipant) {
        for (int i = 0; i < numberOfGame; i++) {
            ResultView.printResultEachRound(autoRacingParticipant.gameEachRound());
        }
    }


}
