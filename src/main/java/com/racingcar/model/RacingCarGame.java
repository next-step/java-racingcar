package com.racingcar.model;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingCarGame {

    private Integer countOfAttempt;
    private List<RacingCar> racingRacingCars;

    public RacingCarGame(Integer countOfCar, Integer countOfAttempt) {
        if (countOfCar <= 0) {
            throw new IllegalArgumentException("플레이할 자동차의 개수는 0개 이상입력해주세요.");
        }

        initRacingCar(countOfCar);
        this.countOfAttempt = countOfAttempt;
    }

    private void initRacingCar(Integer countOfCar) {
        if (CollectionUtils.isEmpty(this.racingRacingCars)) {
            this.racingRacingCars = new ArrayList<>();
        }

        IntStream.range(0, countOfCar).forEach(i -> {
            RacingCar racingCar = new RacingCar(1);
            racingRacingCars.add(racingCar);
        });
    }

    public void playRacingGame() {
        for (RacingCar racingCar : this.racingRacingCars) {
            racingCar.movingRacingCar();
        }
    }

    public List<RacingCar> getRacingRacingCars() {
        return racingRacingCars;
    }

    public Integer getCountOfAttempt() {
        return countOfAttempt;
    }
}
