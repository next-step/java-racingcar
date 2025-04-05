package carrace.race;

import carrace.movement.car.CarMovement;
import carrace.vehicle.Vehicle;
import carrace.vehicle.Vehicles;
import carrace.vehicle.car.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Race {

    private String[] carNames;
    private Vehicles vehicles;
    private int numCar;

    public Race(String[] carNames) {
        this.carNames = carNames;
        this.numCar = carNames.length;
        Vehicle[] vehicles = new Car[numCar];
        IntStream.range(0, this.numCar)
                .forEach(
                        i -> {
                            vehicles[i] = new Car(carNames[i], new CarMovement());
                        });
        this.vehicles = new Vehicles(vehicles);
    }

    // 테스트 목적의 생성자
    public Race(Vehicles vehicles) {
        this.vehicles = vehicles;
    }

    // 게임 시작
    public void startSingleRound() {
        move();
    }

    // 움직임
    public void move() {
        vehicles.moveAll();
    }

    // 위너 계산
    public List<String> getWinner() {
        int maxPosition =
                Arrays.stream(vehicles.getVehicles())
                        .map(Vehicle::getCurrentPosition)
                        .max(Integer::compareTo)
                        .orElseThrow(RuntimeException::new);

        List<String> winnerNames =
                Arrays.stream(vehicles.getVehicles())
                        .filter(car -> car.getCurrentPosition() == maxPosition)
                        .map(Vehicle::getCarName)
                        .collect(Collectors.toList());

        if (winnerNames.isEmpty()) {
            throw new RuntimeException("최종 우승자가 반드시 존재해야합니다.");
        }

        return winnerNames;
    }

    public Vehicles getVehicles() {
        return vehicles;
    }
}
