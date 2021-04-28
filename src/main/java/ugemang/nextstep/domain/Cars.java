package ugemang.nextstep.domain;

import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void round(int turn, int distance){
        for(Car i : this.cars){
            int dist = i.changeGears(distance);
        }
    }
}
