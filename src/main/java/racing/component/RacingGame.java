package racing.component;

import racing.dto.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private List<Car> cars;
    private int carNum;
    private int times;

    public RacingGame(int carNum, int times) {
        this.cars = getCarObjects(carNum);
        this.times = times;
    }

    public List<Car> getCarObjects(int carNum){
        List<Car> cars = new ArrayList<Car>();
        for(int i=0; i<carNum; i++){
            cars.add(new Car(0));
        }

        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTimes() {
        return times;
    }

    public int getRand(){
        return new Random().nextInt(10);
    }

    /**
     * 1회당 움직임
     */
    public void startGame(){
            for(Car c : cars){
                c.countPosition(getRand());
        }
    }



//
//    public List<Car> move(){
//
//
//
//
//        return;
//    }




}
