package study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Scanner;

public class RacingCar {

    private String namePrefix = "test";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carCount = scanner.nextInt();
        int moveCount = scanner.nextInt();
        RacingCar racingCar = new RacingCar();
        racingCar.race(racingCar.makeRacingCar(carCount), moveCount);
    }

    private HashMap<Integer, String> map = new HashMap();

    public void race(List<Car> cars, int moveCount) {
        System.out.println("실행결과");

        for (int i = 0; i <moveCount; i++) {
            for (Car car : cars) {
                car.move();
                car.print();
            }
            System.out.println("");
        }
    }


    public List<Car> makeRacingCar(int carCount) {
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i <carCount ; i++) {
            cars.add(new Car(namePrefix+ i));
        }
        return cars;
    }
}
