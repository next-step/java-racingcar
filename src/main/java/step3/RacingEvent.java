package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingEvent {

    protected List<Car> cars = new ArrayList<>();
    protected int count;
    private ResultView resultView = new ResultView();

    public RacingEvent(int carCount, int tryCont) {
        cars(carCount);
        this.count = tryCont;
    }

    protected void cars(int carCount){
        for(int i = 0; i < carCount; i++){
            this.cars.add(new Car());
        }
    }

    protected void startEvent(){
        for (int i=0; i < count; i++){
            start();
            System.out.println();
        }
    }

    protected void start(){
        for(Car car : cars){
            car.tryMove(RandomUtil.random());
            resultView.resultView(car);
        }
    }
}
