/*
 * edu.nextstep.racingcarwinner.domain.RacingGame.java
 * 0.1 2021.08.07 18:24
 * 해당 클래스의 경우 TDD, CleanCode with Java 수업의 RacingCar step4에 해당됩니다.
 */

package edu.nextstep.racingcarwinner.domain;

import edu.nextstep.racingcarwinner.strategy.RacingStrategy;

import java.util.List;

public class RacingGame {
    private RacingCars racingCars;

    public void joinGame(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public void playOneRound(RacingStrategy racingStrategy){
        racingCars.move(racingStrategy);
    }

    public List<Car> getWinner() {
        return racingCars.findWinner();
    }
}
