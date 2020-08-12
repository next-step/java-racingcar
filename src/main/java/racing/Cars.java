package racing;

import java.util.ArrayList;

public class Cars {
    private ArrayList<Car> carList;
    private CarResultView carResultView = new CarResultView();

    public Cars(int carNumber) {
        carList = new ArrayList<Car>();
        for(int i = 0; i < carNumber; i++) {
            carList.add(new Car());
        }
    }

    private void carRunWithResultView() {
        carList.forEach(car -> {
            car.run();
            System.out.println(carResultView.getLocationLineView(car.getLocation()));
        });
    }

    public void resultViewPrint(int tryCount) {
        carResultView.resultViewMessage();
        for(int i = 0; i < tryCount; i++) {
            carRunWithResultView();
            System.out.println();
        }
    }
}
