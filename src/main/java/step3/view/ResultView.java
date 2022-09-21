package step3.view;

import step3.model.Car;

import java.util.ArrayList;

public class ResultView {
    public void drawResult(ArrayList<Car> list){
        for(Car car : list){
            System.out.println("-".repeat(car.getMoveCnt()));
        }
        System.out.println();
    }

}
