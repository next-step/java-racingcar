package study.step3;

import java.util.List;

public class ResultView {
    public void outPut(List<Car> cars) {
        System.out.println("START============");
        for (Car car : cars) {
            System.out.println(car.getMoveValue());
        }
        System.out.println("END============");
    }
}
