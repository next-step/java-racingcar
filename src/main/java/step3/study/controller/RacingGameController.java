package step3.study.controller;

import step3.study.domain.RequestRacingDTO;
import step3.study.domain.ResponseRacingDTO;
import step3.study.domain.Car;
import step3.study.domain.Cars;
import step3.study.view.InputView;
import step3.study.view.ResultView;

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
        resultView.showResultView(responseRacingDTO.getCars());
    }

    public ResponseRacingDTO startGame(RequestRacingDTO requestRacingDTO) {
        Cars cars = new Cars(Car.ofList(requestRacingDTO));
        return tryRacingGameForTryCount(cars, requestRacingDTO);
    }

    private ResponseRacingDTO tryRacingGameForTryCount(Cars cars, RequestRacingDTO requestRacingDTO) {
        int tryCount = requestRacingDTO.getTryCount();
        for (int i = 0; i < tryCount; i++) {
            cars.move();
        }

        return new ResponseRacingDTO(cars);
    }

    public RequestRacingDTO showInputView() {
        String carCount = inputView.inputCarCount(scanner);
        String tryCount = inputView.inputTryCount(scanner);

        return new RequestRacingDTO(carCount, tryCount);
    }
}
