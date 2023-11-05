package me.namuhuchutong.step3;

public class RacingCarApplication {

    public static void main(String[] args){
        RacingCar racingCar = new RacingCar(
                new RacingService(new RandomRacingRule()),
                new InputView(),
                new OutputView());
        racingCar.start();
    }
}
