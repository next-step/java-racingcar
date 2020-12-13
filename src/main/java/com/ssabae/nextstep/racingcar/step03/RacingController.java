package com.ssabae.nextstep.racingcar.step03;

import com.ssabae.nextstep.racingcar.step03.domain.Cars;
import com.ssabae.nextstep.racingcar.step03.view.CarsPrinter;
import com.ssabae.nextstep.racingcar.step03.view.UserInputHelper;
import java.util.Random;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-06
 */
public class RacingController {

    private final UserInputHelper inputHelper;
    private final Random random;
    private final CarsPrinter carsPrinter;

    public RacingController() {
        this.inputHelper = new UserInputHelper();
        this.random = new Random();
        this.carsPrinter = new CarsPrinter();
    }

    public void playGame() {
        String carNames = inputHelper.inputCarNames();
        int tryCount = inputHelper.inputTryCount();

        Cars cars = new Cars(random, carNames);
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            cars.moving();
            carsPrinter.print(cars);
        }
        carsPrinter.printWinner(cars);
    }
}
