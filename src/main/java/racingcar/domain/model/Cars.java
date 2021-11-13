package racingcar.domain.model;

import racingcar.domain.moverule.MoveRule;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {

    private final List<Car> carList;

    public Cars(int size) {
        this.carList = createCarList(size);
    }

    public Cars(List<CarNameInfo> carNames) {
        this.carList = createCarList(carNames);
    }

    private List<Car> createCarList(List<CarNameInfo> carNames) {
        return carNames.stream()
                .map(carName -> new Car(carName.get()))
                .collect(Collectors.toList());
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

    public List<Car> getCarList(){
        return Collections.unmodifiableList(this.carList);
    }
}