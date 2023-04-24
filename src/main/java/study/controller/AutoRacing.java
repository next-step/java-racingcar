package study.controller;

import study.utils.CarFactory;
import study.domain.AutoRacingParticipant;
import study.domain.GameInfo;
import study.domain.RacingCar;
import study.view.InputView;
import study.view.ResultView;

import java.util.List;

public class AutoRacing {

    public static void startRacing() {

        GameInfo gameInfo = InputView.prepareGame();

        AutoRacingParticipant autoRacingParticipant = new AutoRacingParticipant();

        ResultView.printBeforeGameStart();

        CarFactory carFactory = CarFactory.getInstance();

        List<RacingCar> racingCarList = carFactory.createCar(gameInfo.getNameList());

        autoRacingParticipant.participateGame(racingCarList);

        for (int i = 0; i < gameInfo.getNumberOfGame(); i++) {
            ResultView.printResultEachRound(autoRacingParticipant.gameEachRound());
        }

        ResultView.printName(autoRacingParticipant.getAllMaxMoveCountName());

    }

    public static void main(String[] args) {
        startRacing();
    }
}
