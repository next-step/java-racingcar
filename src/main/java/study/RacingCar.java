package study;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class RacingCar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int carCount = scanner.nextInt();
        int moveCount = scanner.nextInt();
        new RacingCar().race(carCount, moveCount);
    }

    private HashMap<Integer, String> map = new HashMap();

    public void race(int carCount, int moveCount) {
        for (int i = 0; i <carCount ; i++) {
            map.put(i, "");
        }
        System.out.println("실행결과");

        for (int i = 0; i <moveCount; i++) {
            for(int key: map.keySet()) {
                String value = map.get(key);
                if (isMove()) {
                    value += "-";
                }
                map.put(key, value);
            }
            printResult(map);
        }

        System.out.println("map = " + map);
    }

    private boolean isMove() {
        return new Random().nextInt(10) > 4;
    }

    private void printResult(HashMap<Integer, String> map) {
        for (int key :map.keySet()) {
            System.out.println(map.get(key));
        }
        System.out.println("");
    }



}
