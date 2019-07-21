package com.mommoo.step2;

import com.mommoo.step2.domain.CarWinnerComputer;
import com.mommoo.step2.domain.RacingGame;
import com.mommoo.step2.view.InputView;
import com.mommoo.step2.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] carNames = InputView.getCarNames();
        int times = InputView.getCountOfTrying();

        RacingGame racingGame = new RacingGame(carNames);

        List<Car> carList = new ArrayList<>();
        while(times-- > 0) {
            carList = racingGame.move();
            carList.forEach(ResultView::printCarMoveLine);
            System.out.println();
        }

        CarWinnerComputer carWinnerComputer = new CarWinnerComputer(carList);

        ResultView.printFinalWinner(carWinnerComputer);
    }
}
