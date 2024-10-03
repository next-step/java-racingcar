package step5.domain;

import step5.domain.game.GameStrategy;
import step5.domain.situation.GameSituation;
import step5.message.ExceptionMessage;

import java.util.List;

public class PreparedCarGame {

    private GameStrategy gameStrategy;
    private GameSituation gameSituation;

    public void ready(GameStrategy gameStrategy) {
        this.gameStrategy = gameStrategy;
        this.gameSituation = new GameSituation();
    }

    //레이싱을 시작한다.
    public void startRace() {
        this.gameSituation.checkRestart();
        this.gameStrategy.startRace(gameSituation);
    }

    //레이싱의 우승자를 선별한다.
    public List<String> winnerRace() {
        this.gameSituation.checkStart();
        return this.gameStrategy.winnerRace();
    }

    //레이싱 진행 상황을 가져온다.
    public GameSituation getRaceSituation() {
        return this.gameSituation;
    }


}
