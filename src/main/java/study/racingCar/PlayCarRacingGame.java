package study.racingCar;

import static study.racingCar.ResultView.printRacing;

public class PlayCarRacingGame {

    public PlayCarRacingGame() {
    }

    public void play(int cars, CarList carList){
        RandomNumGenerator generator = new RandomNumGenerator();

        for (int j = 0; j < cars; j++) {
            carList.getCar(j).move(generator.randomNum());
            printRacing(carList.getCar(j).currentPosition());
            System.out.println();
        }
    }
}
