package racingcar.domain;
import racingcar.strategy.DoRace;
import racingcar.strategy.RaceCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 일급 콜렉션, 콜렉션 wrapping하며 그 콜렉션 외에 다른 변수는 없는 상태
 * 해당 콜렉션이 아닌 단순 배열/리스트는 ..List ...Arr 로 해서 헷갈리지 않게
 */

public class RacingCars {

    private List<Car> carList;

    public RacingCars(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }


    public List<Integer> allDoRace(int carCounts, int racingCounts) {
        this.carList = new ArrayList<>(carCounts);
        List<Integer> resultList = Arrays.asList(0);

        if (racingCounts == 0) {
            return resultList;
        }
        resultList = carList.stream( )
                .map(Car::getPosition)
                .collect(Collectors.toList( ));
        resultList.add(0);
        racingCounts -= 1;
        resultList.addAll(allDoRace(carCounts, racingCounts));
        return resultList;
    }
}


/*
    public List<Integer> raceCars(List<Car> cars, int racingCounts) {
        List<Car> carList = new ArrayList<Car>();
        for (i = 1; i <= racingCounts; i++) {
            for (j = 0; j < cars.size(); j++) {
                return carList.add(cars[j].move());
            }
        }
    }
*/
