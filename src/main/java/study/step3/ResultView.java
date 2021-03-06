package study.step3;

import java.util.List;

public class ResultView {
    public void printStart(){
        System.out.println("실행 결과");
    }

    public void print(List<RacingCar> racingCars) {

        for(int i=0; i < racingCars.size(); i ++){
            System.out.print( "Car " + (i + 1) + " ");
            carPositionPrint(racingCars.get(i).getPosition());
        }
        System.out.println();
    }

    public void carPositionPrint(int position){

        for(int i=0; i < position; i ++){
            System.out.print("-");
        }
        System.out.println();
    }
}

