package race;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private static List<Integer> carList = new ArrayList<>();

    public static List<Integer> createCar(int number) {
        for (int i=0; i<number; i++) {
            carList.add(0);
        }
        return carList;
    }

    public static boolean canForward(int number) {
        return number >= 4;
    }

    public static void addForward(int index) {
        carList.set(index, carList.get(index) + 1);
    }

    public static void printCar(List<Integer> carList) {
        for (int i=0; i<carList.size(); i++) {
            System.out.println("-".repeat(carList.get(i)));
        }
    }
}

