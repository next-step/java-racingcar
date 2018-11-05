package racingCar;

import java.util.Random;

public class RacingCar {

    //
    public static int move() {
        int condition;
        // TODO 구현
        Random rd = new Random();
        condition = rd.nextInt(10);
        if (isgoing(condition)) {
            return 1;
        }
        return 0;

    }

    public static boolean isgoing(int condition) {
        if (condition >= 4) {
            return true;
        }
        return false;
    }


    public static void startingGame(int time, int[] carPositions) {
        System.out.println("실행 결과");
        for (int i = 0; i < time; i++) {
            carPositions = selectCar(carPositions); //이동하는지 안하는지 구하기!
            printPositions(carPositions); // 결과 출력.
            System.out.println();
        }
    }

    //자동차 선택하기
    public static int[] selectCar(int[] carPositions) {
        for (int i = 0; i < carPositions.length; i++) {
            carPositions[i] += move();
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
