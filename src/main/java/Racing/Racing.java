package Racing;

import java.util.*;

public class Racing {


    public static List racing(String str, int num) {

        List<Car> cars = getCar(playerCar(str));

        for (int i = 0; i < num; i++) {
            moved(cars);
        }

        List<String> winner = printWinner(cars);

        return winner;
    }

    public static List<String> printWinner(List<Car> cars) {

        Collections.sort(cars);
        List<String> winner = new ArrayList<String>();

        winner.add(cars.get(0).getName());
        System.out.print("최종 우승자: " + winner.get(0));

        for(int i = 1; i<cars.size(); i++){
            if(cars.get(0).getMovingRange() == cars.get(i).getMovingRange()) {
                winner.add(cars.get(i).getName());
                System.out.print(", " + cars.get(i).getName());
            }
        }
        return winner;
    }

    private static void moved(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {

            Random random = new Random();
            if (random.nextInt(10) > 4) {
                cars.get(i).moved();
            }
            System.out.print(cars.get(i).getName() + " : ");
            printTrace(cars.get(i));
            System.out.println();
        }
    }

    private static void printTrace(Car aCar) {
        for (int i = 0; i < aCar.getMovingRange(); i++) {
            System.out.print("-");
        }
    }

    private static List<Car> getCar(String[] carNames) {
        List<Car> cars = new ArrayList<Car>();

        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }

        return cars;
    }

    public static String[] playerCar(String str) {

        String[] carNames = str.split(",");

        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > 5) throw new IllegalArgumentException("이름은 5자 이내로 .");
        }

        return carNames;
    }


}