package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameMain {

    public static final int BOUND = 9;

    public static void main(String[] args) {

        //게임 데이터 입력
        RaceInfo raceInfo = RaceInfo.inputInfo();

        //자동차 생성
        List<Car> cars = generateCar(raceInfo.carData());

        //게임 진행 & 상태 출력
        goRacing(cars, raceInfo.trialData());
    }

    public static List<Car> generateCar(int number) {

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Car car = new Car(i);
            cars.add(car);
        }
        return cars;
    }

    public static int random() {
        return new Random().nextInt(BOUND);
    }

    public static void goRacing(List<Car> cars, int trials) {
        for (int i = 0; i < trials; i++) {
            drive(cars);
            System.out.println();
        }
    }

    private static void drive(List<Car> cars) {
        for (Car car : cars) {
            car.move(random());
            System.out.println(status(car));
        }
    }

    private static String status(Car car) {
        StringBuilder status = new StringBuilder();
        for (int i = 0; i < car.carDistance(); i++) {
            status.append("-");
        }
        return status.toString();
    }
}
