package step3.study.controller;

import step3.study.domain.Cars;
import step3.study.domain.RequestRacingDTO;
import step3.study.domain.ResponseRacingDTO;
import step3.study.util.RandomGenerator;
import step3.study.util.Validator;
import step3.study.view.InputView;
import step3.study.view.ResultView;

import java.util.Random;
import java.util.Scanner;

public class RacingGameController {
    private final InputView inputView;
    private final ResultView resultView;
    private final Scanner scanner;

    public RacingGameController() {
        inputView = new InputView();
        resultView = new ResultView();
        scanner = new Scanner(System.in);
    }

    public void run() {
        RequestRacingDTO requestRacingDTO = showInputView();
        ResponseRacingDTO responseRacingDTO = startGame(requestRacingDTO);
        showResultView(responseRacingDTO);
    }

    private void showResultView(ResponseRacingDTO responseRacingDTO) {
        resultView.showResultView(responseRacingDTO);
    }

    public ResponseRacingDTO startGame(RequestRacingDTO requestRacingDTO) {
        Cars cars = new Cars(Cars.of(requestRacingDTO));
        return tryRacingGameForTryCount(cars, requestRacingDTO);
    }

    private ResponseRacingDTO tryRacingGameForTryCount(Cars cars, RequestRacingDTO requestRacingDTO) {
        return cars.moveCarsForTryCount(requestRacingDTO, new RandomGenerator(new Random()));
    }

    public RequestRacingDTO showInputView() {
        int carCount = Validator.numberCheck(inputView.inputCarCount(scanner));
        int tryCount = Validator.numberCheck(inputView.inputTryCount(scanner));

        return new RequestRacingDTO(carCount, tryCount);
    }
}
