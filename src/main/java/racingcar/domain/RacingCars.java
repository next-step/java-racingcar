package racingcar.domain;
import racingcar.strategy.DoOneForward;
import racingcar.strategy.OneForwardCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static racingcar.Constants.INIT_POSITION;


/**
 * 일급 콜렉션, 콜렉션 wrapping하며 그 콜렉션 외에 다른 변수는 없는 상태
 * 해당 콜렉션이 아닌 단순 배열/리스트는 ..List ...Arr 로 해서 헷갈리지 않게
 */

public class RacingCars {
    private int carCounts;
    private int racingCounts;
    private List<Car> cars;

    public List<Car> getCars() { return Collections.unmodifiableList(cars);}


    public RacingCars(int carCounts, int racingCounts) {
        this.cars = createCars(carCounts);
        this.racingCounts = racingCounts;
    }

    public static List<Car> createCars(int carCounts) {
        List<Car> carList = new ArrayList<>(carCounts);
         for (int i = 0 ; i < carCounts; i++) {
            carList.add(new Car(new Position(INIT_POSITION)));
        }
        return carList;
    }


    public void yesRacingCars() {

        this.racingCounts--;
        moveCars();
    }

    public boolean yesRacingCond() {
        return this.racingCounts > 0;
    }

    private void moveCars() {
        for (Car car:cars) {car.move(new OneForwardCondition(), new DoOneForward());
        }
    }

}



/* BEFORE
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

 */



