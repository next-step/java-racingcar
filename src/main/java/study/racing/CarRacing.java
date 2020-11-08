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

        InputView.validateCarCount(carCnt);
        InputView.validateTryCount(tryCnt);

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



    private Set<Car> initCarSet(int carCnt) {
        Set<Car> cars = IntStream.range(0, carCnt)
                .mapToObj(car -> new Car())
                .collect(Collectors.toSet());
        return cars;
    }


    public static void main(String args[]){

        int carCnt = InputView.getCarCount();
        int tryCnt = InputView.getTryCount();

        CarRacing carRacing = new CarRacing();
        carRacing.racing(carCnt, tryCnt);
    }
}
