package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Racing {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대인가요?");
        int cars = scan.nextInt();

        List<Car> carList = setCars(cars);

        System.out.println("시도할 회수는 몇 회 인가요?");
        int challenges = scan.nextInt();

        System.out.println("실행 결과");
        raceByRound(carList, challenges);
    }

    public static List<Car> setCars(int cars) {
        List<Car> carsList = new ArrayList<>();
        for (int i = 0; i < cars; i++) {
            carsList.add(new Car());
        }
        return carsList;
    }

    public static void raceByRound(List<Car> carList, int challenges) {
        for (int i = 0; i < challenges; i++) {
            raceByCar(carList);
            System.out.println();
        }
    }

    public static void raceByCar(List<Car> carList) {
        for (Car car : carList) {
            move(car, getRandom());
            System.out.println(car.getPosition());
        }
    }

    public static void move(Car car, int random) {
        if (random >= 4) {
            car.setPosition(car.getPosition());
        }
    }

    public static int getRandom() {
        Random random = new Random();
        return random.nextInt(10);
    }

}
