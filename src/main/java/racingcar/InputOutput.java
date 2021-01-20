package racingcar;

import java.util.ArrayList;
import java.util.Scanner;

public class InputOutput {
    public static Scanner scanner = new Scanner(System.in);

    public static String inputCarsName() {
        String carsName = null;
        boolean isValidCarsName = false;
        while (!isValidCarsName) {
            carsName = scanner.next();
            isValidCarsName = validateCarsName(carsName);
        }
        return carsName;
    }
    private static boolean validateCarsName(String carsName) {
        try {
            Validator.checkEmptyElement(carsName);
            Validator.checkLastValueComma(carsName);
            Validator.checkCarNameLength(carsName);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static int inputStages() {
        String stages = null;
        boolean isValidStages = false;
        while (!isValidStages) {
            stages = scanner.next();
            isValidStages = validateStages(stages);
        }
        return Integer.parseInt(stages);
    }

    private static boolean validateStages(String stages) {
        try {
            Validator.checkNumber(stages);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void printCurrentCarsState(ArrayList<Car> carsList){
        System.out.println("\n실행 결과");
        for(Car car : carsList){
            printCarInfo(car);
        }
    }

    private static void printCarInfo(Car car){
        StringBuffer carInfo = new StringBuffer();
        carInfo.append(car.getName());
        carInfo.append(" : ");
        for(int i = 0; i < car.getDistance(); ++i){
            carInfo.append("-");
        }
        System.out.println(carInfo);
    }

    public static void printWinners(ArrayList<Car> carsList, int maxDistance) {
        System.out.print("최종 우승자 : ");
        for(Car car : carsList) {
            printWinner(car, maxDistance);
        }
        System.out.println("");
    }

    private static void printWinner(Car car, int maxDistance) {
        if(car.getDistance() == maxDistance) {
            System.out.print(car.getName() + " ");
        }
    }
}
