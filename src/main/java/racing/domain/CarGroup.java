package racing.domain;

import racing.message.ViewMsg;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {
    private List<Car> carList;
    private static ResultView resultView = new ResultView();

    public CarGroup(String[] arrCarName) {
        carList = new ArrayList<Car>();
        for (int i=0; i<arrCarName.length; i++) {
            carList.add(new Car(arrCarName[i]));
        }
    }

    public void print(int repeatCount) {
        resultView.viewResultMsg();
        for (int i=0; i<repeatCount; i++) {
            carRunWithView();
            System.out.println(ViewMsg.END_LINE.getMsg());
        }
        Victory victory = new Victory(carList);
        resultView.printVictory(victory.getNames());
    }

    private void carRunWithView() {
        carList.stream().forEach(car -> {
            car.run();
            resultView.viewGameStatus(car);
        });
    }
}
