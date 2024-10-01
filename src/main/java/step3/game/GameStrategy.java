package step3.game;

import step3.car.CarStrategy;

import java.util.List;

public interface GameStrategy {

    //경기를 준비한다.
    void readyRace(int carNum, int attemptNum);

    //자동차를 가져온다.
    List<CarStrategy> getRacingCars();

    //전진 시도횟수를 가져온다.
    int getAttemptNum();

    //자동차 전진을 1회 시도한다.
    void attemptForwardCar();

}
