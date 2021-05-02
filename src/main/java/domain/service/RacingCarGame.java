package domain.service;

import domain.core.RacingCar;
import utils.InputCarName;
import utils.InputMove;
import utils.exception.CarNameAtLeastOneCommaWhenSplitException;
import utils.exception.CarNameExceedFiveCharacterException;

public class RacingCarGame implements Game {

    @Override
    public void run() {
        RacingCar racingCar = new RacingCar(inputCarName());
        int move = inputMove();
        play(racingCar, move);
    }

    private void play(RacingCar racingCar, int move) {
        System.out.println();
        System.out.println("실행 결과");
        racingCar.playAll(move);
        racingCar.printWinner();
    }

    private int inputMove() {
        boolean isInput = true;
        int move = 0;
        while (isInput) {
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                move = InputMove.inMove(); // Exception 체크
                isInput = false;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }

        return move;
    }

    private String[] inputCarName() {
        boolean isInput = true;
        String[] carNames = null;
        while (isInput) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                carNames = InputCarName.inCarName(); // Exception 체크
                isInput = false;
            } catch (CarNameExceedFiveCharacterException | CarNameAtLeastOneCommaWhenSplitException e) {
                System.out.println(e.getMessage());
            }
        }

        return carNames;
    }
}
