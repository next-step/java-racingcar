package step3.race;

import step3.model.Car;
import step3.model.Cars;
import step3.view.Print;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private int raceTimes;
    private int size;
    private Cars cars = new Cars();

    public Race(int size, int raceTimes) {
        this.raceTimes = raceTimes;
        cars.makeCars(size);
        this.size = size;
    }

    public void doRace(){
        for (int time = 0; time < raceTimes; time++) {
            moveCars(time);
            Print.print(cars.getCars());
            System.out.println();
        }
    }

    private void moveCars(int time) {
        if(time == 0){
            cars.firstMovement();
            return;
        }
        cars.moveCars();
    }

    public int getRaceTimes() {
        return raceTimes;
    }

    public List<Integer> getPositions() {
        if(size <= 0){
            throw new IllegalStateException("주행할 자동차가 없습니다.");
        }
        List<Integer> result = new ArrayList<>();
        for(Car car : cars.getCars()){
            result.add(car.getPosition());
        }
        return result;
    }

    public int getCarsSize() {
        return this.size;
    }

    public static Race of(int size, int raceTimes){
        return new Race(size,raceTimes);
    }
}
