package step3;

import static step3.Racing.run;

import java.util.List;

public class ResultView {

    public void resultView(List<Car> cars){
        for (Car car : cars) {
            run(car);
            System.out.println(car.getRun());
        }
        System.out.println();
    }
}
