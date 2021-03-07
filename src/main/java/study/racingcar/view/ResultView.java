package study.racingcar.view;

import study.racingcar.entity.RacingCar;

import java.util.List;

public class ResultView {

    public void printStart(){
        System.out.println("실행 결과");
    }

    public void print(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            printCarName(racingCar);
            printCarPosition(racingCar);
        }
        System.out.println();
    }

    public void printCarName(RacingCar racingCar){
        System.out.print(racingCar.getName() + " : ");
    }

    private void printCarPosition(RacingCar racingCar) {
        for(int i = 0; i < racingCar.getPosition(); i ++){
            System.out.print("-");
        }
        System.out.println();
    }

    public void printsWinner(String winnerNames) {
        System.out.print(winnerNames + "가 최종 우승했습니다.");
    }
}

