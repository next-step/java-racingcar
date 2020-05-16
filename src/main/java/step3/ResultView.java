package step3;

import java.util.List;

public class ResultView {

    private ResultView() {
        System.out.println("\n실행 결과");
    }

    public static void print(List<Car> carList) {
        for (Car car : carList)
            System.out.println("-".repeat(car.getPosition()));
        System.out.println();
    }
}
