package racingcar;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {
    private final static int GO_CONDITION = 4;
    private int time;
    private List<Car> cars = new ArrayList<>();
    private NumGenerator randomNumGenerator;

    private RacingGame() {

    }

    public RacingGame(int time, int carNum, NumGenerator randomNumGenerator) {
        this.time = time;
        this.cars = IntStream.range(0, carNum).mapToObj(i -> new Car(0)).collect(Collectors.toList());
        this.randomNumGenerator =  randomNumGenerator;
    }

    public List<Cars> run() {
        List<Cars> histories = new ArrayList<>();
        for (int i = 0; i < this.time; i++) {
            List<Car> c = moveCars(this.cars);
            histories.add(new Cars(c));
        }
        return histories;

    }

    public List<Car> moveCars(List<Car> cars){
        List<Car> carList = new ArrayList<>();

        for (Car car : cars) {
            Car newCar = move(car);
            carList.add(newCar);
        }
        return carList;

    }

    public Car move(Car car){
        int randomNum = getRandomNum();
        if (randomNum >= GO_CONDITION) {
            car.addPosition();
        }
        return new Car(car.getPosition());
    }

    public int getRandomNum() {
        return this.randomNumGenerator.getNextInt();
    }


}
