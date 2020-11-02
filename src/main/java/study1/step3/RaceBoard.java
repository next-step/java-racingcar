package study1.step3;

import java.util.List;

public class RaceBoard {
    RaceBoard(){
        System.out.println("실행 결과");
    }

    void show(List<Car> carList){
        for(Car car: carList){
            System.out.println(car.getMoveDistance());
        }
        System.out.println("");
    }
}
