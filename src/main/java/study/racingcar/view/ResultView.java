package study.racingcar.view;

import study.racingcar.domain.RacingCar;

import java.util.List;

public class ResultView {

    public void printStart(){
        System.out.println("실행 결과");
    }

    public void print(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            System.out.println(racingCar.getPrintInfo());
        }
        System.out.println();
    }

    public void printsWinner(String winnerNames) {
        System.out.print(winnerNames + "가 최종 우승했습니다.");
    }
}

