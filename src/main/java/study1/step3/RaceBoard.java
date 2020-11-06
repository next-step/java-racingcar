package study1.step3;

import java.util.List;

public class RaceBoard {
    RaceBoard(){
        System.out.println("실행 결과");
    }

    void show(List<Car> carList){
        for(Car car: carList){
            System.out.println(getMoveDistance(car));
        }
        System.out.println("");
    }

    private StringBuilder getMoveDistance(Car car){
        StringBuilder raceDistance = new StringBuilder();
        for(int i = 0; i < car.getMoveDistance(); i++){
            raceDistance.append("-");
        }
        return raceDistance;
    }
}
