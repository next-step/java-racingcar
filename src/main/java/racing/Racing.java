package racing;

import java.util.*;

public class Racing {


    public static List racing(String str, int num) {

        List<Car> cars = getCar(playerCar(str));

        for (int i = 0; i < num; i++) {
            random(cars);
        }

        List<String> winner = printWinner(cars);

        return winner;
    }

    public static void checkSame(List<Car> cars, List<String> winnerArr, int index, Car winner) {
        if (winner.getMovingRange() == cars.get(index).getMovingRange()) {
            winnerArr.add(cars.get(index).getName());
            System.out.print(", " + cars.get(index).getName());
        }
    }

    public static List<String> printWinner(List<Car> cars) {

        Collections.sort(cars);
        List<String> winner = new ArrayList<String>();

        winner.add(cars.get(0).getName());
        System.out.print("최종 우승자: " + winner.get(0));

        for (int i = 1; i < cars.size(); i++) {
            checkSame(cars, winner, i, cars.get(0));
        }
        return winner;
    }

    public static void random(List<Car> cars) {
        Random random = new Random();
        for (int i = 0; i < cars.size(); i++) {
            moved(random.nextInt(10), cars.get(i));
            System.out.print(cars.get(i).getName() + " : ");
            printTrace(cars.get(i));
            System.out.println();
        }
    }
    public static void random(List<Car> cars, int mustMove) {
        int count = 0;
        for(Car car: cars) {
            moved(mustMove + count, car);
            System.out.println(car.getName() + " : ");
            printTrace(car);
            System.out.println();
            count++;
        }
    }

    public static void moved(int random, Car car) {
        if (random > 4) car.moved();
    }


    private static void printTrace(Car aCar) {
        for (int i = 0; i < aCar.getMovingRange(); i++) {
            System.out.print("-");
        }
    }

    private static List<Car> getCar(String[] carNames) {
        List<Car> cars = new ArrayList<Car>();

        for (String carName: carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public static String[] playerCar(String str) {

        String[] carNames = str.split(",");

        for (String carName : carNames) {
            if (carName.length() > 5) throw new IllegalArgumentException("이름은 5자 이내로 .");
        }

        return carNames;
    }


}
