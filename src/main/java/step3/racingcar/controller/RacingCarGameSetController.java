package step3.racingcar.controller;

import java.util.Scanner;
import step3.racingcar.exception.RacingCarGameException;
import step3.racingcar.model.RacingCar;
import step3.racingcar.model.RacingCarEngine;
import step3.racingcar.model.RacingCarGameRound;
import step3.racingcar.model.RacingCarGameSet;
import step3.racingcar.view.RacingCarGameRoundView;

public class RacingCarGameSetController {

    final private static int THRESHOLD = 4;

    private RacingCarGameSet gameSet;

    public void setReady() {
        int numberOfCars = getNumberOfCars();
        int numberOfRounds = getNumberOfRounds();
        RacingCar[] cars = initCars(numberOfCars);
        RacingCarGameRound[] gameRounds = initRounds(numberOfRounds, cars);
        this.gameSet = new RacingCarGameSet(cars, gameRounds);
    }

    public int getNumberOfCars() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("자동차 대수는 몇 대 인가요? - ");
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요.");
        }
        throw new RacingCarGameException("숫자를 입력받는데 실패했습니다.");
    }

    public int getNumberOfRounds() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("시도할 회수는 몇 회 인가요? - ");
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요.");
        }
        throw new RacingCarGameException("숫자를 입력받는데 실패했습니다.");
    }

    public RacingCar[] initCars(int numberOfCars) {
        RacingCar[] cars = new RacingCar[numberOfCars];
        for (int i = 0; i < numberOfCars; i++) {
            cars[i] = new RacingCar(i, new RacingCarEngine(THRESHOLD));
        }
        return cars;
    }

    public RacingCarGameRound[] initRounds(int numberOfRounds, RacingCar[] cars) {
        RacingCarGameRound[] gameRounds = new RacingCarGameRound[numberOfRounds];
        for (int i = 0; i < numberOfRounds; i++) {
            gameRounds[i] = new RacingCarGameRound(i, cars);
        }
        return gameRounds;
    }

    public void setStart() {
        for (RacingCarGameRound gameRound : this.gameSet.gameRounds()) {
            RacingCarGameRoundController gameRoundController = new RacingCarGameRoundController();
            gameRoundController.roundReady(gameRound);
            gameRoundController.roundStart();

            RacingCarGameRoundView gameRoundView = new RacingCarGameRoundView(gameRound);
            gameRoundView.showGameRound();
        }
    }

}
