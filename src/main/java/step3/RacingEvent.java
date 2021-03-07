package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingEvent {

    private List<Car> cars = new ArrayList<>();
    private int count;
    private ResultView resultView = new ResultView();

    public RacingEvent(int carCount, int tryCont) {
        cars(carCount);
        this.count = tryCont;
    }

    private void cars(int carCount){
        for(int i = 0; i < carCount; i++){
            this.cars.add(new Car());
        }
    }

    public void startEvent(){
        for (int i=0; i < count; i++){
            start();
            System.out.println();
        }
    }

    private void start(){
        for(Car car : cars){
            car.move();
            resultView.resultView(car);
        }
    }
}
