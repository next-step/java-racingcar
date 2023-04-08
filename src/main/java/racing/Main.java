package racing;

import racing.carRacing.Count;
import racing.carRacing.view.InputView;

public class Main {
    public static void main(String[] args) {
        Count numberOfCar = Count.createCount(InputView.askNumberOfCar());
        System.out.println("numberOfCar = " + numberOfCar);
    }
}
