package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CarRacingMain {

    private static final String firstRequest = "자동차 대수는 몇 대 인가요?";
    private static final String secondRequest = "시도할 회수는 몇 회 인가요?";
    private static final int randomValue = 10;
    private static final int racingConditionValue = 3;
    private static List<CarModel> carModelList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(firstRequest);
        if (scanner.hasNext()) {
            createCarByNumber(intValueByScanner(scanner.next()));
        }
        System.out.println(secondRequest);
        if (scanner.hasNext()) {
            tryRacingByCar(intValueByScanner(scanner.next()));
        }
        scanner.close();
    }

    public static int intValueByScanner(String scannerValue) {
        int intValue = toInt(scannerValue);
        System.out.println(scannerValue);
        return intValue;
    }

    public static int toInt(String inputValue) {
        validByNumberCheck(inputValue);
        return Integer.parseInt(inputValue);
    }

    public static void validByNumberCheck(String inputValue) {
        String regExp = "^\\d+$";
        if (!inputValue.matches(regExp)) {
            throw new IllegalArgumentException("해당 문자는 숫자만 사용 가능합니다.");
        }
    }

    public static List<CarModel> createCarByNumber(int totalCarNumber) {
        for (int i = 0; i < totalCarNumber; i++) {
            CarModel carModel = new CarModel(i + 1);
            carModelList.add(carModel);
        }
        return carModelList;
    }

    public static void tryRacingByCar(int tryraceNumber) {
        for (int i = 0; i < tryraceNumber; i++) {
            racing();
        }
    }

    public static void racing() {
        for (CarModel carModel : carModelList) {
            carModel.carRacingAct(getRaceDistance(randomValue()));
        }
        System.out.println();
    }

    public static int randomValue() {
        return new Random().nextInt(randomValue);
    }

    public static boolean getRaceDistance(int randomValue) {
        return randomValue > racingConditionValue;
    }

}
