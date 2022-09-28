package Service;

import java.util.List;

import domain.Car;

public class ResultView {


    public void printCarLocation(CarRace carRace, List<Car> cars, int attempts) {
        for (int i = 0; i < attempts; i++) {
            convertCarLocation(carRace, cars);
            System.out.println();
        }
    }

    public void convertCarLocation(CarRace carRace, List<Car> list1) {
        List<Car> list = carRace.updateCurrentLocation(list1);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName() + " : " + list.get(i).getCurrentLocation());
        }
    }
}
