package carrace.race;

import carrace.common.Vehicle;
import carrace.movement.car.CarMovement;
import carrace.utils.RandomValue;
import carrace.vehicle.car.Car;
import carrace.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Race {

    private String[] carNames;
    private int numTry;
    private Vehicle[] vehicles;
    private int numCar;

    public Race(String[] carNames, int numTry) {
        this.carNames = carNames;
        this.numTry = numTry;
        this.numCar = carNames.length;
        vehicles = new Vehicle[numCar];
        IntStream.range(0, this.numCar)
                .forEach(
                        i -> {
                            vehicles[i] = new Car(carNames[i], new CarMovement());
                        });
    }

    // 게임 시작
    public void start(OutputView outputView) {
        IntStream.range(0, numTry)
                .forEach(
                        i -> {
                            move();
                            outputView.printCurrentState(vehicles);
                        });
    }

    // 게임 종료후 해야할 사항들
    public void end(OutputView outputView) {
        outputView.printWinner(getWinner());
    }

    // 움직임
    public void move() {
        IntStream.range(0, numCar)
                .forEach(
                        i -> {
                            vehicles[i].move(RandomValue.generate());
                        });
    }

    // 위너 계산
    private String getWinner() {
        int maxPosition =
                Arrays.stream(vehicles)
                        .mapToInt(car -> car.getCurrentPosition().length())
                        .max()
                        .orElseThrow(RuntimeException::new);

        List<String> winnerNames =
                Arrays.stream(vehicles)
                        .filter(car -> car.getCurrentPosition().length() == maxPosition)
                        .map(car -> car.getCarName())
                        .collect(Collectors.toList());

        return String.join(",", winnerNames);
    }
}
