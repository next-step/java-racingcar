package com.next.step.step3.service;

import com.next.step.step3.domain.Cars;
import com.next.step.step3.dto.InputDto;
import com.next.step.step3.util.CarsFactory;
import com.next.step.step3.view.ResultView;

import java.util.List;

public class RacingGame {

    public void executeRace(InputDto inputDto) {
        Cars cars = new Cars(CarsFactory.createCars(inputDto));
        ResultView resultView = new ResultView();

        resultView.showResultTitle();
        for (int attempt = 0; attempt < inputDto.numOfAttempts(); attempt++) {
            cars.moveCars();
            resultView.showResultContents(cars);
        }
        winnerElection(cars, resultView);
    }

    private void winnerElection(Cars cars, ResultView resultView) {
        List<String> winnerNames = WinnerElection.electionWinners(cars);
        resultView.showWinnerNames(winnerNames);
    }
}
