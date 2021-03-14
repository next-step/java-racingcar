package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private GameSet gameSet;
    private int currentRound = 0;

    public RacingGame(GameSet gameSet) {
        this.gameSet = gameSet;
    }

    public List<RacingCar> settingRacingCars(int cars) {

        ArrayList<RacingCar> list = new ArrayList<>();

        for (int i = 0; i < cars; i++) {
            RacingCar racingCar = new RacingCar(new Position());
            list.add(racingCar);
        }

        return list;
    }

    public void gameStart(List<RacingCar> carList, int count) {
        numberingGameTimes(carList, count);
    }

    private void numberingGameTimes(List<RacingCar> carList, int count) {
        for (int i = 0; i < count; i++) {
            numberingCars(carList);
            currentRound++;
            System.out.println("");
        }
    }

    private void numberingCars(List<RacingCar> carList) {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).move();
            System.out.println(carList.get(i).status());
        }
    }

    public boolean gameOver() {
        return currentRound == gameSet.getGivenRound();
    }
}
