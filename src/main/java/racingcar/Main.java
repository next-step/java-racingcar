package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler(new Scanner(System.in));

        ArrayList<String> carNames = inputHandler.getCarName();
        Boolean startGame = inputHandler.checkCarName(carNames); // 자동차 이름 유효성 검사

        if (!startGame) {
            OutputHandler.exitMessage();
        }

        int laps = inputHandler.inputLaps(); // 랩 횟수 입력 받기

        List<Car> cars = CarGenerator.genearteCarList(inputHandler.getCarNameStr());

        Game game = new Game();

        for(int i = 0; i < laps; i++) {
            game.proceedRound(cars);
            OutputHandler.displayDash(cars);
        }

        OutputHandler.racingResult(game.getWinners(cars));
    }

}
