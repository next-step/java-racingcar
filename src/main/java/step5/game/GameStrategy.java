package step5.game;

import step5.car.CarStrategy;

import java.util.List;

public interface GameStrategy {

    //경기를 준비한다.
    void readyRace(String carName, int attemptNum);

    void startRace();

    //자동차 전진을 1회 시도한다.
    void attemptForwardCar();

    List<String> winnerRace();

    List<List<CarStrategy>>  getRaceSituation();

}
