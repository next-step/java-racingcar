package racing.ui;

import racing.domain.Car;

import java.util.List;

public class ResultView {

    static String DISPLAY_TEST = "-";

    public void viewResultView(List<Car> carList) {
        for(Car car : carList){
            System.out.println(intFormatString(car.getMoveCount(car)));
        }
        System.out.println();
    }

    private String intFormatString(int count){
        return DISPLAY_TEST.repeat(count);
    }

}
