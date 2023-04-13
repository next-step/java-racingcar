package CarRacing.view;

import CarRacing.Car;

import java.util.List;

public class ResultView {

    public void printCurrentDistance(List<Car> cars) {
        for(int idxCar=0; idxCar < cars.size(); idxCar++) {
            for (int idxDist=0; idxDist < cars.get(idxCar).current(); idxDist++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
