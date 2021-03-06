package study.step3;

import java.util.List;

public class ResultView {

    public void printStart(){
        System.out.println("실행 결과");
    }

    public void print(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            for(int i=0; i < racingCar.getPosition(); i ++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}

