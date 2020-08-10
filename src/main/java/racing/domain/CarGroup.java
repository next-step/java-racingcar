package racing.domain;

import racing.message.ViewMsg;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarGroup {
    private List<Car> carList;
    private static ResultView resultView = new ResultView();

    public CarGroup(String[] arrCarName) {
        carList = new ArrayList<Car>();
        for (int i = 0; i < arrCarName.length; i++) {
            carList.add(new Car(arrCarName[i]));
        }
    }

    public void print(int repeatCount) {
        resultView.viewResultMsg();
        for (int i = 0; i < repeatCount; i++) {
            carRunWithView();
            System.out.println(ViewMsg.END_LINE.getMsg());
        }
        resultView.printVictory(getWinnerNames());
    }

    private void carRunWithView() {
        carList.stream().forEach(car -> {
            car.run();
            resultView.viewGameStatus(car);
        });
    }

    public String getWinnerNames() {
        return carList.stream()
                .filter(car -> car.getLocation() == getTopLocation())
                .map(car -> car.getName())
                .collect(Collectors.joining(", "));
    }

    public int getTopLocation() {
        return carList.stream()
                .max(Comparator.comparingInt(Car::getLocation))
                .get()
                .getLocation();
    }

}
