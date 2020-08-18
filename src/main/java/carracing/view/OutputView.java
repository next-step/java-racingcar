package carracing.view;

import carracing.domain.Car;

public class OutputView {
    public void getResultView(Car car) {
        String carNumber = String.valueOf(car.getCarNumber());
        String output = "";
        for(int i = 0; i < car.getPosition(); i++) {
            output += "-";
        }
        System.out.println(carNumber + output);
    }
}
