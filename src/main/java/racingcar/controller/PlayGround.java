package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.ResultView;

import java.util.List;

public class PlayGround {
    public static void play(int loopCount, List<Car> cars){
        ResultView resultView = new ResultView();
        System.out.println("실행 결과");
        for (int i=0; i<loopCount; i++){
            resultView.printCars(cars);
        }
    }
}