package car;

import java.util.Scanner;

public class CarRacing {
    private final InputView inputView;
    public  CarRacing() {
        inputView = new InputView();
    }

    public void start() {
        int carNum = inputView.enterCarCount();
        int tryNum = inputView.enterTryCount();


    }
}
