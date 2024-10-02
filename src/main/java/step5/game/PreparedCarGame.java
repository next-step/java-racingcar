package step5.game;

import step4.message.ExceptionMessage;
import step5.car.CarStrategy;

import java.util.ArrayList;
import java.util.List;

public class PreparedCarGame {

    private GameStrategy gameStrategy;

    public void setGameStrategy(GameStrategy gameStrategy) {
        this.gameStrategy = gameStrategy;
    }

    public void ready(String carName, int attempt) {
        this.gameStrategy.readyRace(carName, attempt);
    }

    //레이싱을 시작한다.
    public void startRace() {
        checkRestart();
        this.gameStrategy.startRace();
    }

    //레이싱의 우승자를 선별한다.
    public List<String> winnerRace() {
        checkStart();
        return this.gameStrategy.winnerRace();
    }

    //레이싱 진행 상황을 가져온다.
    public List<List<CarStrategy>> getRaceSituation() {
        return this.gameStrategy.getRaceSituation();
    }

    //레이싱 재시작하는지를 체크한다.
    private void checkRestart() {
        if (!getRaceSituation().isEmpty())
            throw new IllegalArgumentException(ExceptionMessage.GAME_ALREADY_START.message());
    }

    //시작을 했는지 안했는지 체크한다.
    private void checkStart() {
        if (getRaceSituation().isEmpty())
            throw new IllegalArgumentException(ExceptionMessage.GAME_NOT_START.message());
    }
}
