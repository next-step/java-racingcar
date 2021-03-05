package racing;

import java.util.List;

public class ResultView {

    public void printCar(List<Car> carList) {
        carList.forEach(car -> System.out.println(car.getTrack()));
        System.out.println();
    }

}
