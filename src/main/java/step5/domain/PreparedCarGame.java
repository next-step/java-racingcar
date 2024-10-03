package step5.domain;

import step5.domain.car.CarStrategy;
import step5.domain.game.GameStrategy;
import step5.message.ExceptionMessage;

import java.util.ArrayList;
import java.util.List;

public class PreparedCarGame {

    private GameStrategy gameStrategy;
    private final List<List<CarStrategy>> raceSituation = new ArrayList<>();

    public void ready(GameStrategy gameStrategy) {
        this.gameStrategy = gameStrategy;
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
        return this.raceSituation;
    }

    //레이싱 재시작하는지를 체크한다.
    private void checkRestart() {
        if (!this.raceSituation.isEmpty())
            throw new IllegalArgumentException(ExceptionMessage.GAME_ALREADY_START.message());
    }

    //시작을 했는지 안했는지 체크한다.
    private void checkStart() {
        if (this.raceSituation.isEmpty())
            throw new IllegalArgumentException(ExceptionMessage.GAME_NOT_START.message());
    }
}
