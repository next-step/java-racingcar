package racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RacingCarUtils {

    public static String[] parseCarNames(String text) {
        String[] names = new String[0];

        if(checkPattern(text)) {
            names = splitText(text);
        }

        return names;
    }

    public static boolean checkPattern(String text) {
        Pattern pattern = Pattern.compile("^(([a-zA-Z]+),)+([a-zA-Z]+)$");
        Matcher matcher = pattern.matcher(text);

        return matcher.find();

    }

    public static String[] splitText(String text) {
        return text.split(",");
    }

    public static List<Car> getCars(String[] names) {
        List<Car> carList = new ArrayList<>();

        for (String name : names) {
            Car car = new Car(name);
            carList.add(car);
        }
        return carList;
    }

    public static void moveCars(List<Car> cars, int moveCnt) {

        for (Car car : cars) {
            car.move(moveCnt);
        }

    }

    public static void sortCars(List<Car> cars) {

        Collections.sort(cars);

    }

    public static List<Car> rankCars(List<Car> cars) {

        List<Car> winners = new ArrayList<>();
        Car winner = cars.get(0);
        winners.add(winner);

        for (int i = 1; i < cars.size(); i++) {
            checkSameScore(winner.getTotalDistance(), cars.get(i), winners);
        }

        return winners;
    }

    public static void checkSameScore(int topDistance, Car otherCar, List<Car> winners) {
        if (topDistance == otherCar.getTotalDistance()) {
            winners.add(otherCar);
        }
    }

    public static void viewRacingCar(List<Car> cars, int moveCnt) {

        for (int i = 0; i < moveCnt; i++) {

            for (int j = 0; j < cars.size(); j++) {

                System.out.print(cars.get(j).getName() + ": ");

                for (int k = 0; k < i + 1; k++) {
                    if (cars.get(j).getMoveList().get(k) == 1) {
                        System.out.print("-");
                    }
                }

                System.out.println();
            }

            System.out.println();

        }
    }

    public static void viewRacingCarWinners(List<Car> cars) {
        String winners = "";
        for (Car car : cars) {
            winners += car.getName() + ", ";
        }
        System.out.println(winners.substring(0, winners.length()-2) + "가 최종 우승했습니다.");
    }


}
