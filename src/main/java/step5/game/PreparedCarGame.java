package step5.game;

import step5.car.CarStrategy;

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
        this.gameStrategy.startRace();
    }

    //레이싱의 우승자를 선별한다.
    public List<String> winnerRace() {
        return this.gameStrategy.winnerRace();
    }

    //레이싱 진행 상황을 가져온다.
    public List<List<CarStrategy>> getRaceSituation() {
        return this.gameStrategy.getRaceSituation();
    }
}
