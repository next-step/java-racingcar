package racing;

import racing.controller.RaceGame;
import racing.dto.RaceRequestDto;
import racing.dto.RaceResponseDto;
import racing.view.InputView;
import racing.view.ResultView;

public class Main {
    public static void main(String[] args) {

        String[] carNames = InputView.insertNamesOfCars();
        int attempts = InputView.insertNumberOfAttempts();

        RaceGame raceGame = new RaceGame();
        RaceResponseDto responseDto = raceGame.startRacing(new RaceRequestDto(carNames, attempts));

        ResultView.printResult(responseDto);
    }
}
