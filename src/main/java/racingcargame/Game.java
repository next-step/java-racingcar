package racingcargame;

import java.util.List;

public class Game {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carNumber = inputView.getCarNumber();
        int playCount = inputView.getPlayCount();

        RacingPlay racingPlay = new RacingPlay();
        OutputView outputView = new OutputView();

        List<Car> carList = racingPlay.readyForRacing(carNumber);

        System.out.println("실행 결과");
        for (int i = 0; i < playCount; i++) {
            racingPlay.playRacingCar(carList);
            outputView.output(carList);
        }
    }
}
