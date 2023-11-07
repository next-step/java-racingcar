package me.namuhuchutong.step4;

public class RacingCarApplication {

    public static void main(String[] args){
        RacingCar racingCar = new RacingCar(
                new InputView(), new OutputView(), new RacingCarService(new RandomRacingRule()));
        racingCar.start();
    }
}
