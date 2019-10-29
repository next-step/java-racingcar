package step2;

import java.util.ArrayList;
import java.util.List;

public class ResultView {


    public void printResultView(List<Car> cars) {

        for (Car car : cars) {
            printBar(car.getPosition());
        }
        System.out.println();
    }

    public void printBar(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("- ");
        }
        System.out.println();
    }
}
