package study.racing;

import study.calculator.CustomErrorMessage;
import study.racing.view.InputView;
import study.racing.view.ResultView;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRacing {


    public void racing(int carCnt, int tryCnt){

        ResultView resultView = new ResultView();
        resultView.showResultHead();

        validateCarCount(carCnt);
        validateTryCount(tryCnt);

        Set<Car> carSet = initCarSet(carCnt);

        IntStream.range(0, tryCnt)
                .mapToObj(tryIndex -> {
                    resultView.showLapResultHead(tryIndex);
                    return carSet;
                })
                .forEach(cars -> {

                            cars.forEach(car -> {
                                        car.move(car.getRandomInt());
                                    }
                            );

                            cars.forEach(car -> resultView.showCarRacingLapResult(car));
                        }
                );
    }

    private void validateTryCount(int tryCnt) {
        if(tryCnt == 0){
            throw new IllegalArgumentException(RacingErrorMessage.ZERO_TRY_COUNT.getErrorMessage());
        }
    }

    private void validateCarCount(int carCnt) {
        if(carCnt == 0){
            throw new IllegalArgumentException(RacingErrorMessage.ZERO_CAR_COUNT.getErrorMessage());
        }
    }

    private Set<Car> initCarSet(int carCnt) {
        Set<Car> cars = IntStream.range(0, carCnt)
                .mapToObj(car -> new Car())
                .collect(Collectors.toSet());
        return cars;
    }


    public static void main(String args[]){
        InputView inputView = new InputView();
        int carCnt = inputView.setCarCount();
        int tryCnt = inputView.setTryCount();

        CarRacing carRacing = new CarRacing();
        carRacing.racing(carCnt, tryCnt);
    }
}
