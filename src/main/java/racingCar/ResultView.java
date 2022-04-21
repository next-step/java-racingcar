package racingCar;

import java.util.List;

public class ResultView {
    public void resultOfCar(Position position){
        for(int i=0; i<position.getPosition(); i++){
            System.out.print("-");
        }
        System.out.println("");
    }

    public void resultOfCars(List<Car> cars){
        for (int i=0; i<cars.size(); i++) {
            this.resultOfCar(cars.get(i).currentPosition());
            cars.get(i).move(new RandomNumber());
        }
        System.out.println("");
    }

}
