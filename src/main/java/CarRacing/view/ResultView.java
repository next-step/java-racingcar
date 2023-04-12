package CarRacing.view;

import CarRacing.Car;

public class ResultView {

    public void printCurrentDistance(Car car) {
        for (int idxDist=0; idxDist < car.current()+1; idxDist++){
            System.out.print("-");
        }
        System.out.println();
    }
}
