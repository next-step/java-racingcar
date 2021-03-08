package study.step3;

import java.util.List;

public class Cars {
    //불변
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    /**
     * 상태와 로직을 한곳에!
     * */
    public void move(){
        for(Car car : cars){
            car.move();
        }
    }
}
