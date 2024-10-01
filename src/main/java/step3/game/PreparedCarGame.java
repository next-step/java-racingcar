package step3.game;

import step3.car.CarStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PreparedCarGame {

    private GameStrategy gameStrategy;
    private final List<List<CarStrategy>> raceSituation = new ArrayList<>();

    public void ready(GameStrategy gameStrategy) {
        this.gameStrategy = gameStrategy;
    }

    //레이싱을 시작한다.
    public void startRace() {
        for (int i = 0; i < gameStrategy.getAttemptNum(); i++) {
            this.gameStrategy.attemptForwardCar();
            this.raceSituation.add(copyCarStrategy());
        }
    }

    public List<List<CarStrategy>> getRaceSituation() {
        return raceSituation;
    }

    //CarStrategy 객체를 새로운주소로 copy한다.
    private List<CarStrategy> copyCarStrategy() {
        return this.gameStrategy.getRacingCars().stream()
                .map(CarStrategy::copy)
                .collect(Collectors.toList());
    }

}
