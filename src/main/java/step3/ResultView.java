package step3;

import java.util.List;

public class ResultView {

    ResultView() {
        System.out.println("\n실행 결과");
    }

    public void print(List<Car> carList) {
        for (Car car : carList)
            System.out.println("-".repeat(car.getPosition()));
        System.out.println();
    }
}
