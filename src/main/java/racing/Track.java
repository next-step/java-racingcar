package racing;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private List<Car> cars;
    private final RacingOption option;

    Track(RacingOption option) {
        this.option = option;
    }

    public void createCars(){
        this.cars = new ArrayList<>();
        for (int idx = 0; idx < this.option.carCnt; idx++) {
            this.cars.add(new Car());
        }
    }

    public void start(int reps) {
        for (int rep = 0; rep < reps; rep++) {
            this.startOneRep();
        }
    }

    private void startOneRep() {
        for (Car car : this.cars) {
            ResultView.printMove(car.move());
        }
        System.out.println();
    }
}
