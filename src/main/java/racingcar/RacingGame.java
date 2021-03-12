package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private int currentRound = 0;

    private int cars;
    private int givenRound;


    public RacingGame(int cars, int givenRound) {
        this.cars = cars;
        this.givenRound = givenRound;
    }

    public List<RacingCar> settingRacingCars(int cars) {

        ArrayList<RacingCar> list = new ArrayList<>();

        for (int i = 0; i < cars; i++) {
            RacingCar racingCar = new RacingCar(new Car());
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
        for (int j = 0; j < carList.size(); j++) {
            carList.get(j).move();
            System.out.println(carList.get(j).status());
        }
    }

    public int getRound() {
        return currentRound;
    }

}
