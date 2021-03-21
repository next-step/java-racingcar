package ch01.racinggame.view;

import ch01.racinggame.Domain.Car;
import ch01.racinggame.Domain.RacingGame;

import java.util.ArrayList;

public class ResultView {

    Car[] cars;
    RacingGame racingGame;

    public ResultView() {
        System.out.println("실행결과");
    }

    public ResultView(RacingGame racingGame){
        this.racingGame = racingGame;
    }

    public void showResult() {

        this.cars = racingGame.cars();
        this.print();
    }

    public void showWinnerResult(){
        ArrayList<Car> winnerCar = racingGame.winner();
        showWinners(winnerCar);
    }

    private void print() {
        for (int i = 0; i < cars.length; i++) {
            nullAndEmpty(cars[i]);
        }
        System.out.println();
    }

    private void nullAndEmpty(Car car) {
        if (car != null) {
            System.out.println(car.name()+":"+car.toString());
        }
    }

    private void showWinners(ArrayList<Car> winners){
        StringBuilder out = new StringBuilder();
        String result = new String();
        for(Car car : winners){
            out.append(car.name()+", ");
        }


        result = out.substring(0,out.lastIndexOf(","));
        System.out.println(result+"가 최종 우승했습니다.");
    }


}
