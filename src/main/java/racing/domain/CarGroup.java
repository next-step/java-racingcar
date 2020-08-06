package racing.domain;

import racing.message.ViewMsg;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {
    private List<Car> carList;
    private static ResultView resultView = new ResultView();

    public CarGroup(int carCount) {
        carList = new ArrayList<Car>();
        for (int i=0; i<carCount; i++) {
            carList.add(new Car());
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void print(int repeatCount) {
        resultView.viewResultMsg();
        for (int i=0; i<repeatCount; i++) {
            carRunWithView();
            System.out.println(ViewMsg.END_LINE.getMsg());
        }
    }

    private void carRunWithView() {
        carList.stream().forEach(car -> {
            car.run();
            System.out.println(resultView.getLocationVisualization(car.getLocation()));
        });
    }


}
