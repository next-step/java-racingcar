package step3;

import java.util.List;

public class OutputView {
    private final String RESULT_MENTION = "실행결과";

    public void resultMention() {
        System.out.println(RESULT_MENTION);
    }

    public void displayCarList(List<Car> carList) {
        for(Car car : carList) {
            displayCar(car);
        }
        System.out.println();
    }

    private void displayCar(Car car) {
        for(int position = 0; position < car.getCurrentPosition(); position++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
