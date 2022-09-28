package step3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private final List<Car> cars;
    private int tryCnt;

    public RacingGame(int carCnt, int tryCnt) {
        this.cars = initCar(carCnt);
        this.tryCnt = tryCnt;
    }

    public RacingGame(List<Car> cars, int tryCnt){
        this.cars = cars;
        this.tryCnt = tryCnt;
    }

    private List<Car> initCar(int carCnt) {
        return IntStream.range(0, carCnt)
                .mapToObj(idx -> new Car())
                .collect(Collectors.toList());
    }


    public void race(MoveStrategy moveStrategy) {
        this.cars.forEach(car -> car.moveWithStrategy(moveStrategy));
        this.tryCnt--;
    }

    public boolean isEnd() {
        return this.tryCnt == 0;
    }

    public List<Integer> currentPositions() {
        return this.cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }

    public RacingGame resetGame(int carCnt, int tryCnt){
        return new RacingGame(carCnt, tryCnt);
    }

    public int getTryCnt(){
        return this.tryCnt;
    }

}
