
//    초간단 자동차 경주 게임을 구현한다.
//    주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. => 자동차 대수 숫자로 입력받기(숫자 아니면 에러)
//    사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. => 이동횟수 숫자로 입력받기(숫자 아니면 에러)
//    전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다. => random() (4가 아닐 때 전진하는지 확인)
//    자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다. => 이동할때마다 표시하기(print)

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;

public class CarRacing {
    private static final Random random = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final int CONDITION_NUMBER = 4;
    private static final int DISTANCE_PER_TRY = 1;
    private static final int ERROR_STAUTS = 1;

    static void racing(int numberOfCar, int numberOfTry) {
        if (numberOfCar == 0) {
            numberOfCar = getNumberOfCar(null);
        }

        if (numberOfTry == 0) {
            numberOfTry = getNumberOfTry(null);
        }

        if ( numberOfCar < 0 || numberOfTry < 0 ) {
            requestReTypePositiveNumber();
            throw new IllegalArgumentException("negative number is not supported");
        }

        int[] distancesDriven = new int[numberOfCar];

        for (int idxTry=0; idxTry < numberOfTry; idxTry++) {
            for(int idxCar=0; idxCar < numberOfCar; idxCar++) {
                distancesDriven[idxCar] += drive(random.nextInt(10));
                for (int idxDist=0; idxDist < distancesDriven[idxCar]+1; idxDist++){
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }

    }

     static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    static int getNumberOfCar(String numberStr) {
        if (!containText(numberStr)) {
            System.out.println("자동차 대수는 몇 대 인가요?");
            numberStr = SCANNER.nextLine();
        }

        if (!isNumeric(numberStr)) {
            requestReTypeNumber();
            throw new IllegalArgumentException("check number of car");
        }

        int number = Integer.parseInt(numberStr);

        return number;
    }

    static int getNumberOfTry(String numberStr) {
        if (!containText(numberStr)) {
            System.out.println("시도할 횟수는 몇 회 인가요?");
            numberStr = SCANNER.nextLine();
        }

        if (!isNumeric(numberStr)) {
            requestReTypeNumber();
            throw new IllegalArgumentException("check number of try");
        }

        int number = Integer.parseInt(numberStr);

        return number;
    }

    private static boolean containText(String inputText) {
        return (inputText != null) && !inputText.isEmpty() && !inputText.isBlank();
    }

    static int drive(int number) {
        if (number >= CONDITION_NUMBER) {
            return DISTANCE_PER_TRY;
        }

        return 0;
    }

    private static void requestReTypeNumber() {
        System.out.println("숫자로만 입력해주세요!");
    }

    private static void requestReTypePositiveNumber() {
        System.out.println("양의 숫자만 입력해주세요!");
    }

}

