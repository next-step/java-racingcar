package Service;

import domain.Car;
import java.util.List;

public class ResultView {


    public void printCarLocation(List<Car> carList, int attempts) {

        for (int i = 0; i < attempts; i++) {
            convertCarLocation(carList);
        }
    }

    public void convertCarLocation(List<Car> carList) {
        CarRace.updateCurrentLocation();
        for (int i = 0; i < carList.size(); i++) {
            for (int j = 0; j < carList.get(i).getCurrentLocation(); j++) {
                System.out.print(carList.get(i).getName() + ":" + "-");
            }
            System.out.println();
        }
    }
}
