package racing;

import racing.view.InputView;

import java.util.ArrayList;

public class RacingGame {
    private int time;
    private int car;
    private ArrayList<Car> carPositions = new ArrayList<Car>();

    public void race() {
        car = InputView.inputCar();
        time = InputView.inputTime();

        for(int i=0; i<car; i++){
            carPositions.add(new Car(i,1));
        }
    }


}
