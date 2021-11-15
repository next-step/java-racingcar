package Racing;

import Racing.car.Car;
import Racing.car.CarList;
import Racing.stage.Stage;
import Racing.stage.StageStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racing {

    private final CarList cars;

    public Racing(int countOfCar) {
        List<Car> cars = IntStream.range(0, countOfCar).mapToObj(i -> new Car()).collect(Collectors.toList());

        this.cars = new CarList(cars);
    }

    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int countOfCar = scanner.nextInt();


        System.out.println("시도할 회수는 몇 회 인가요?");
        int countOfStage = scanner.nextInt();

        String run = new Racing(countOfCar).run(countOfStage);

        System.out.println("\n실행결과");
        System.out.println(run);
    }

    public String run(int countOfStage) {
        List<Stage> stages = new ArrayList<>();

        for (int i = 0; i < countOfStage; i++) {
            stages.add(new Stage());
        }

        return stages.stream()
                .filter(targetStage -> targetStage.status.equals(StageStatus.READY))
                .map((this::getCarsDisplay))
                .collect(Collectors.joining());
    }

    private String getCarsDisplay(Stage stage) {
        stage.moveCars(cars);
        return cars.displayCarDistance().toString() + "\n\n";
    }
}
