package carracing.view;

import carracing.domain.Car;

public class OutputView {
    public void getResultView(Car car) {
        String carName = car.getCarName();
        String output = "";
        for(int i = 0; i < car.getPosition(); i++) {
            output += "-";
        }
        System.out.println(carName + " : " + output);
    }
}
