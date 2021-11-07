package racingcar.car;

import racingcar.moverule.MoveRule;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {

    private final List<Car> carList;
    private final MoveRule moveRule;

    public Cars(MoveRule moveRule, int size) {
        this.moveRule = moveRule;
        this.carList = createCarList(size);
    }

    private List<Car> createCarList(int size){
        return Stream.generate(Car::new)
                .limit(size)
                .collect(Collectors.toList());
    }

    public void playGame(){
        this.carList
                .forEach((car) -> car.move(moveRule.isMovable(), moveRule.getMoveCount()));
    }

    public void printPosition() {
        this.carList
                .forEach((car) -> System.out.println(car.printPosition()));
    }

    public List<Car> getCarList(){
        return this.carList;
    }
}