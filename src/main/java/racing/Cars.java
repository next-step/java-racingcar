package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public List<Car> carList;
    CarResultView carResultView = new CarResultView();

    public Cars(int carNumber) {
        carList = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            carList.add(new Car());
        }
    }

    private void carRunWithResultView() {
        carList.forEach(car -> {
            car.run(car.getRandomNumber());
            System.out.println(carResultView.getLocationLineView(car.getLocation()));
        });
    }

    public void resultViewPrint(int tryCount) {
        carResultView.resultViewMessage();
        for (int i = 0; i < tryCount; i++) {
            carRunWithResultView();
            System.out.println();
        }
    }
}
