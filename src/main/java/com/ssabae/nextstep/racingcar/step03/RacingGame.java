package com.ssabae.nextstep.racingcar.step03;

import com.ssabae.nextstep.racingcar.step03.domain.Cars;
import java.util.Random;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-06
 */
public class RacingGame {

    private final UserInputHelper inputHelper;
    private final Random random;

    public RacingGame() {
        inputHelper = new UserInputHelper();
        random = new Random();
    }

    public void playGame() {
        int carsCount = inputHelper.inputCarsCount();
        int tryCount = inputHelper.inputTryCount();

        Cars cars = new Cars(random);
        cars.initCars(carsCount);

        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            cars.moving();
            cars.printCars();
        }
    }
}
