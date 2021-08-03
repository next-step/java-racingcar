package kr.co.techmoa.carracing.ui;

import kr.co.techmoa.carracing.model.Car;
import kr.co.techmoa.carracing.model.RacingCarGame;
import kr.co.techmoa.carracing.model.Round;

import java.util.List;

public class ResultView {

    public static final String RASCING_DISTINC = "-";
    public static final String SEPARATOR = " : ";

    public void printResult(RacingCarGame racingCarGame) {

        List<Car[]> carList = racingCarGame.getRounds();

        for(int i = 0 ; i < carList.size() ; i++) {
            Car[] cars = carList.get(i);
            printMove(cars);
        }
    }

    public void printMove(Car[] cars) {
        for(Car car: cars) {
            print(car);
        }
        System.out.println("");
    }

    public void print(Car car) {
        System.out.print(car.getCarName() + SEPARATOR);
        for(int i = 0 ; i < car.getTotalMove() ; i++) {
            System.out.print(RASCING_DISTINC);
        }
        System.out.println("");

    }
}
