package study.step3;

import java.util.List;

public class ResultView {

    public void printStart(){
        System.out.println("실행 결과");
    }

    public void print(List<RacingCar> racingCars) {
        racingCars.forEach(RacingCar::printPosition);
        System.out.println();
    }
}

