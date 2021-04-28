package ugemang.nextstep.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Curcuit {
    private final int round;
    private final List<Car> cars;

    public Curcuit(int round, List<Car> cars) {
        validatePositiveRound(round);
        validateExistsCars(cars);
        this.round = round;
        this.cars = cars;
    }

    public Integer getRound() {
        return round;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void lap(int count) {
        if(isOverRound(count)) {
            throw new IllegalArgumentException("");
        }

        for(Car i : this.cars){
            i.changeGears();
        }
    }

    public List<Car> getWinner(){
        List<Car> carsSortByDistance = new ArrayList<>();
        carsSortByDistance.addAll(getCars());
        carsSortByDistance.sort(Comparator.comparingInt(i->i.getTotalDistance()));
        Integer distanceTopRank = carsSortByDistance.get(carsSortByDistance.size()-1).getTotalDistance();
        carsSortByDistance.removeIf(car -> car.getTotalDistance() < distanceTopRank);
        return carsSortByDistance;
    }

    public boolean isOverRound(int count){
        if(getRound() < count){
            return true;
        }
        return false;
    }

    private void validatePositiveRound(int round) {
        if(round < 0){
            throw new IllegalArgumentException(String.format("라운드는 음수가 될 수 없음", round));
        }
    }

    private void validateExistsCars(List<Car> cars) {
        if(cars.size() <= 1){
            throw new IllegalArgumentException(String.format("경주용 자동차는 2대 이상 있어야합니다", cars.size()));
        }
    }
}
