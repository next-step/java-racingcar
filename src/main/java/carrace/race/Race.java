package carrace.race;

import carrace.common.Vehicle;
import carrace.movement.car.CarMovement;
import carrace.utils.RandomValue;
import carrace.vehicle.car.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Race {

    private final String[] carNames;
    private final int numTry;
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
    public void start() {
        IntStream.range(0, numTry)
                .forEach(
                        i -> {
                            updateCurrentState();
                            printCurrentState();
                        });
        printWinner();
    }

    // 상태 업데이트 (움직임)
    public void updateCurrentState() {
        IntStream.range(0, numCar)
                .forEach(
                        i -> {
                            vehicles[i].move(RandomValue.generate());
                        });
    }

    // 상태 출력
    private void printCurrentState() {
        Arrays.stream(vehicles)
                .forEach(
                        car ->
                                System.out.println(
                                        car.getCarName() + ": " + car.getCurrentPosition()));
        System.out.println();
    }

    // 위너 출력
    private void printWinner() {
        System.out.println("최종 우승자는 " + getWinner() + " 입니다.");
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
