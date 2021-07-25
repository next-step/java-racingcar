package step4.action;

import step4.model.Car;
import step4.model.CarMovement;
import step4.model.Cars;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private int size;
    private Cars cars = new Cars(new CarMovement());

    public Race(int size) {
        cars.makeCars(size);
        this.size = size;
    }

    public static Race of(int size) {
        return new Race(size);
    }

    public void doRace(){
        cars.moveCars();
    }

    public int getCarsSize() {
        return this.size;
    }

    public List<Integer> getPositions() {
        if(size <= 0){
            throw new IllegalStateException("주행할 자동차가 없습니다.");
        }
        List<Integer> result = new ArrayList<>();
        for (Car car : cars.getCars()) {
            result.add(car.getPosition());
        }
        return result;
    }
}
