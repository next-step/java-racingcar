package racingCar;

import java.util.Random;

public class RacingCar {


    private static final int randomBoundary=10;
    private static final int conditionBoundary=4;

    public static int createRandomValue(){
        return new Random().nextInt(randomBoundary);
    }

    public static int move(int randomValue) {
        int moveCount = 0;

        if (isgoing(randomValue)) {
           moveCount++;
        }

        return moveCount;

    }

    public static boolean isgoing(int condition) {
        return condition > conditionBoundary;
    }


    public static void startingGame(int time, int[] carPositions) {
        System.out.println("실행 결과");
        for (int i = 0; i < time; i++) {
            carPositions = moveCar(carPositions); //이동하는지 안하는지 구하기!
            printPositions(carPositions); // 결과 출력.
            System.out.println();
        }
    }

    //자동차 선택하기
    public static int[] moveCar(int[] carPositions) {
        for (int i = 0; i < carPositions.length; i++) {
            carPositions[i] += move(createRandomValue());
        }

        return carPositions;
    }


    public static void printPositions(int[] carPositions) {

        for (int position : carPositions) {
            showPosition(position);
        }
    }

    public static void showPosition(int distance) {
        String position = "";
        for (int i = 0; i < distance; i++) {
            position += '-';
        }
        System.out.println(position);
    }


}
