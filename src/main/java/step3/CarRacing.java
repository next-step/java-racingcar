package step3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CarRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountOfCar = scanner.nextInt();
        int count = scanner.nextInt();

        Map<Integer, Integer> cars = new HashMap<>();
        for (int i=0; i<amountOfCar; i++) {
            cars.put(i, 0);
        }


    }
}