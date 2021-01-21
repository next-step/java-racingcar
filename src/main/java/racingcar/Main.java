package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputHandler ip = new InputHandler();

        ArrayList<String> carNames = ip.inputCarName();
        Boolean startGame = ip.carNameChecker(carNames); // 자동차 이름 유효성 검사
        if (!startGame) {
            OutputHandler.exitMessage();
        }

        int laps = ip.inputLaps(); // 랩 횟수 입력 받기
        List<Car> cars = GenerateCar.ofCars(ip.getCarNameStr());
        Game game = new Game();
        for(int i=0; i<laps; i++) {
            game.round(cars);
            OutputHandler.displayDash(cars);
        }

        OutputHandler.racingResult(game.getWinners(cars));
    }

}
