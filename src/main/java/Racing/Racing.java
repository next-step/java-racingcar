package Racing;

import java.util.*;

public class Racing {


    private static final int NAME_LENGTH = 5;
    private static final int MOVE_NUMBER = 4;
    private static final int MAX_RANDOM = 10;
    private static final int WINNER_NUMBER = 0;
    private static  Random random = new Random();

    public static List racing(String str, int num) {

        List<Car> cars = getCar(playerCar(str));

        for (int i = 0; i < num; i++) {
            random(cars);
        }

        List<String> winner = getWinners(cars);

        return winner;
    }

//    public static void checkSame(List<Car> cars, List<String> winnerArr, int index, Car winner) {
//        if (winner.getMovingRange() == cars.get(index).getMovingRange()) {
//            winnerArr.add(cars.get(index).getName());
//            System.out.print(", " + cars.get(index).getName());
//        }
//    }

    public static List<String> getWinners(List<Car> cars) {

        Collections.sort(cars);
        List<String> winner = new ArrayList<>();

        winner.add(cars.get(WINNER_NUMBER).getName());


        System.out.print("최종 우승자: " + winner.get(WINNER_NUMBER));

        for (int i = 1; i < cars.size(); i++) {
            if(cars.get(i).getMovingRange() ==cars.get(WINNER_NUMBER).getMovingRange()){
                winner.add(cars.get(i).getName());
            }
        }


        return winner;
    }

    private static void random(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
           moved(random.nextInt(MAX_RANDOM), cars.get(i));
            System.out.print(cars.get(i).getName() + " : ");
            printTrace(cars.get(i));
            System.out.println();
        }
    }

    public static void moved(int random, Car car) {
        if (random > MOVE_NUMBER) car.moved();
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
            if (carNames[i].length() > NAME_LENGTH) throw new IllegalArgumentException("이름은 5자 이내로 .");
        }

        return carNames;
    }


}
