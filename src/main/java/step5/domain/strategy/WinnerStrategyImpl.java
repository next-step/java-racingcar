package step5.domain.strategy;

import step5.domain.Car;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WinnerStrategyImpl implements WinnerStrategy{
    @Override
    public List<Car> getWinner(List<Car> carList) {

        Car winner = carList.get(0);

        Iterator<Car> iterator = carList.iterator();
        List<Car> winners = new ArrayList<>();

        while(iterator.hasNext()){
            Car nextCar = iterator.next();
            if(winner.getPosition() != nextCar.getPosition()){
                break;
            }
            winners.add(nextCar);
        }

        return winners;
    }
}
