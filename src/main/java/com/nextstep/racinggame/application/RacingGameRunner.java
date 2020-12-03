package com.nextstep.racinggame.application;

import com.nextstep.racinggame.domain.Cars;
import com.nextstep.racinggame.domain.GasStation;
import com.nextstep.racinggame.domain.RandomGasStation;

import java.util.Scanner;

public class RacingGameRunner {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final GasStation GAS_STATION = new RandomGasStation();

    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carDemand = SCANNER.nextInt();

        Cars cars = Cars.of(carDemand);

        Cars racedCars = RacingGame.race(cars, GAS_STATION);
        System.out.println(RacingGameResultDrawer.drawGameResult(racedCars));
    }
}
