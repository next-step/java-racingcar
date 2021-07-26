package step4.action;

import step4.model.Car;
import step4.model.CarsMethod;
import step4.model.Cars;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private int size;
    private Cars cars = new Cars(new CarsMethod());

    private Race(List<Car> cars) {
        this.cars = new Cars(cars,new CarsMethod());
        this.size = cars.size();
    }

    public static Race of(List<Car> cars){
        return new Race(cars);
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
        for (Car car : cars.getCarList()) {
            result.add(car.getPosition());
        }
        return result;
    }

    public List<Car> getCars() {
        return cars.getCarList();
    }

    public List<Car> getWinner(){
        List<Car> arrangeCars = cars.arrangeCars();
        return findWinner(arrangeCars);
    }

    protected List<Car> findWinner(List<Car> cars){
        List<Car> winners = new ArrayList<Car>();
        int longestLength = cars.get(0).getPosition();
        winners.add(cars.get(0));
        for(int idx=1; idx < cars.size(); idx++){
            sameWithFirst(winners, cars.get(idx),longestLength);
        }
        return winners;
    }

    private void sameWithFirst(List<Car> winners, Car car,int target) {
        if(car.getPosition() == target){
            winners.add(car);
        }
    }
}
