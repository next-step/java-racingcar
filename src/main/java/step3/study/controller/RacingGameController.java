package step3.study.controller;

import step3.study.domain.Drivers;
import step3.study.dto.RequestRacingDTO;
import step3.study.dto.ResponseRacingDTO;
import step3.study.util.RandomGenerator;
import step3.study.util.StringUtils;
import step3.study.util.Validator;
import step3.study.view.InputView;
import step3.study.view.ResultView;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGameController {
    private final InputView inputView;
    private final ResultView resultView;
    private final Scanner scanner;
    private final static int LAST_ROUND = 1;

    public RacingGameController() {
        inputView = new InputView();
        resultView = new ResultView();
        scanner = new Scanner(System.in);
    }

    public void run() {
        RequestRacingDTO requestRacingDTO = showInputView();

        Drivers drivers = new Drivers(Drivers.of(requestRacingDTO));

        int tryCount = requestRacingDTO.getTryCount();
        for (int i = 0; i < tryCount; tryCount--) {
            ResponseRacingDTO responseRacingDTO = tryRacingGame(drivers);
            showResultView(responseRacingDTO);
            showWinner(tryCount, responseRacingDTO);
        }
    }

    private void showWinner(int tryCount, ResponseRacingDTO responseRacingDTO) {
        if (LAST_ROUND == tryCount) {
            Drivers drivers = responseRacingDTO.getDrivers();
            List<String> winnerNames = drivers.getWinnerNames();
            resultView.printWinnerNames(winnerNames);
        }
    }

    private void showResultView(ResponseRacingDTO responseRacingDTO) {
        resultView.showResultView(responseRacingDTO);
    }

    public ResponseRacingDTO tryRacingGame(Drivers drivers) {
        return drivers.moveCars(new RandomGenerator(new Random()));
    }

    public RequestRacingDTO showInputView() {
        String driverName = inputView.inputDriverNames(scanner);
        String[] driverNames = null;
        if (Validator.isNotEmpty(driverName)) {
            driverNames = StringUtils.split(driverName, ",");
        }

        int tryCount = Validator.numberCheck(inputView.inputTryCount(scanner));

        return new RequestRacingDTO(driverNames, tryCount);
    }
}
