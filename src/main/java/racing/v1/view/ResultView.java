package racing.v1.view;

import racing.v1.model.Car;

public class ResultView {
    public void printCarMove(Car car){
        for(int i = 0; i < car.getPosition(); i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public void printStepEnd(){
        System.out.println();
    }
}
