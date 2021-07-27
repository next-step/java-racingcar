package step4.action;

import step4.model.Car;
import step4.model.CarMoveAndArrangeStrategy;
import step4.model.Cars;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Race {

    private Cars cars;

    public Race(List<Car> carList) {
        this.cars = new Cars(carList,new CarMoveAndArrangeStrategy());
    }

    public void doRace(){
        cars.moveCars();
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
        findCoWinner(winners, cars);

        return winners;
    }

    private void findCoWinner(List<Car> winners, List<Car> cars) {
        Iterator<Car> iterator = cars.iterator();
        Car winner = iterator.next();

        winners.add(winner);
        while(iterator.hasNext()){
            Car nextCar = iterator.next();
            if(winner.getPosition() != nextCar.getPosition()){
                break;
            }
            winners.add(nextCar);
        }
    }
}
