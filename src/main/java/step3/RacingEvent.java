package step3;

import step3.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingEvent {

    private List<Car> cars = new ArrayList<>();
    private ResultView resultView = new ResultView();

    public List<Car> getCars(){
        return this.cars;
    }

    void readyEvent(int CarCount){
        for(int i = 0; i < CarCount; i++){
            cars.add(new Car());
        }
    }

    void startEvent(int tryCount){
        resultView.startResult();
        for(int i = 0; i < tryCount; i++){
            System.out.println("");
            moveCars();
        }
    }

    private void moveCars(){
        for(Car car : cars){
            if(new Forward().successForward()){
                car.moveForward();
            }
            resultView.showPosition(car.getCurrentPosition());
        }
    }

}
