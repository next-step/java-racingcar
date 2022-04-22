package controller;

import dto.CarInfo;
import model.MoveCount;
import service.RacingCarGame;
import view.InputView;
import view.ResultView;

import java.util.List;

public class RacingGameController {

    public static void main(String args[]) {
        String carsName = InputView.getInputCarsName();
        MoveCount moveCount = InputView.getInputCarMoveCount();

        RacingCarGame racingCarGame = new RacingCarGame(carsName, moveCount);

        ResultView.printResult();
        while (!racingCarGame.isDone()) {
            racingCarGame.race();
            printResult(racingCarGame.getCarsInfo());
        }
    }

    private static void printResult(List<CarInfo> carInfos) {
        for (CarInfo carDto : carInfos) {
            ResultView.printExecuteResult(carDto.getCarName(), carDto.getPosition());
        }
        ResultView.printLineBreak();
    }

}
