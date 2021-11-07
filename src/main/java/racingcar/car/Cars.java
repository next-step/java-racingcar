package racingcar.car;

import racingcar.moverule.MoveRule;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {

    private final List<Car> carList;

    public Cars(int size) {
        this.carList = createCarList(size);
    }

    private List<Car> createCarList(int size){
        return Stream.generate(Car::new)
                .limit(size)
                .collect(Collectors.toList());
    }

    public void playGame(MoveRule moveRule){
        this.carList
                .forEach(car -> car.move(moveRule.isMovable(), moveRule.getMoveCount()));
    }

    public void printPosition() {
        this.carList
                .forEach(car -> System.out.println(car.printPosition()));
    }

    public List<Car> getCarList(){
        return Collections.unmodifiableList(this.carList);
    }
}