import java.util.Scanner;
import java.util.Random;

public class CarRacing {
    private static final Random random = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final int CONDITION_NUMBER = 4;
    private static final int DISTANCE_PER_TRY = 1;

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

