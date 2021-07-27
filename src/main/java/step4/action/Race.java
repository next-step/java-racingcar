package step4.action;

import step4.model.Car;
import step4.model.CarMoveAndArrangeStrategy;
import step4.model.Cars;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private int size;
    private Cars cars;

    public Race(List<Car> carList) {
        this.cars = new Cars(carList,new CarMoveAndArrangeStrategy());
        this.size = carList.size();
    }
//
//    private Race(String[] names){
//        this.cars = new Cars(new CarMoveAndArrangeStrategy());
//        cars.makeCars(names);
//        this.size = cars.getCarList().size();
//    }
//
//    public static Race of(List<Car> cars){
//        return new Race(cars);
//    }
//    public static Race of(String[] names){
//        return new Race(names);
//    }
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
            findWinner(winners, cars.get(idx),longestLength);
        }
        return winners;
    }

    private void findWinner(List<Car> winners, Car car, int target) {
        if(car.getPosition() == target){
            winners.add(car);
        }
    }
}
