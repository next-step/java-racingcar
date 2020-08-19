package step3;

import java.util.ArrayList;

public class RacingEvent {

    private ArrayList<Car> carList = new ArrayList<>();

    public RacingEvent(int carCount, int tryCount){
        readyEvent(carCount);
        startEvent(tryCount);
    }

    public ArrayList<Car> getCarList(){
        return this.carList;
    }

    private void readyEvent(int count){
        for(int i = 0; i < count; i++){
            carList.add(new Car());
        }
    }

    private void startEvent(int count){
        for(int i = 0; i < count; i++){
            for(Car car : carList){
                car.moveForward(new Forward().tryMove());
            }
        }
    }
}
