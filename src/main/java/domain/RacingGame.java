package domain;

import java.util.Arrays;
import java.util.List;
import util.Ramdom;

public class RacingGame {

    private final Cars racingCars;
    private int round;

    public RacingGame(String carNames, int tryNo) {
        this.racingCars = new Cars(parseCarNames(carNames));
        this.round = tryNo;
    }

    public Cars getRacingCars() {
        return racingCars;
    }

    public int getRound() {
        return round;
    }

    public String getWinners() {
        return racingCars.convertWinner();
    }

    public void race() {
        for (int i = 0; i < racingCars.getCars().size(); i++) {
            if (Ramdom.isMove()) {
                racingCars.moveCar(i);
            }
        }
        round--;
    }

    public boolean isEnd() {
        return round <= 0;
    }

    private List<String> parseCarNames(String carNames) {
        return Arrays.asList(carNames.split(","));
    }
}
