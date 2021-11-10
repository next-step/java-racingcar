package racingcar.domain;

import racingcar.moverule.MoveRule;
import racingcar.view.result.ResultView;

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

    public void printRoundResult(ResultView resultView){
        this.carList
                .forEach(car -> resultView.printRoundResult(car));
    }

    public void printWinner(ResultView resultView){
        resultView.printWinner(this.getWinnerCars());
    }

    public List<Car> getCarList(){
        return Collections.unmodifiableList(this.carList);
    }

    public List<Car> getWinnerCars(){
        int maxPosition = Collections.max(
                this.carList.stream()
                        .map(car -> car.getPosition())
                        .collect(Collectors.toList())
        );
        return Collections.unmodifiableList(
                this.carList.stream()
                        .filter(car -> car.getPosition() == maxPosition)
                        .collect(Collectors.toList())
        );
    }
}