package CarRacing.view;

import CarRacing.Car;

import java.util.List;

public class ResultView {

    public void printCurrentDistance(List<Car> cars) {
        for(int idxCar=0; idxCar < cars.size(); idxCar++) {
            StringBuilder distance = new StringBuilder();
            for (int idxDist=0; idxDist < cars.get(idxCar).current(); idxDist++){
                distance.append("-");
            }
            System.out.print(distance);
            System.out.println();
        }
        System.out.println();
    }
}
