package study;

import java.util.List;

public class AutoRacing {

    public static void startRacing() {

        GameInfo gameInfo = InputView.prepareGame();

        AutoRacingParticipant autoRacingParticipant = new AutoRacingParticipant();

        ResultView.printBeforeGameStart();

        CarFactory carFactory = CarFactory.getInstance();

        List<RacingCar> racingCarList = carFactory.createCar(gameInfo.getNameList());

        autoRacingParticipant.participateGame(racingCarList);

        autoRacingParticipant.doGame(gameInfo.getNumberOfGame());
    }

    public static void main(String[] args) {
        startRacing();
    }
}
