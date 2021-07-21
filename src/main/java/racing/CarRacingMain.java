package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CarRacingMain {

    private static final String firstRequest = "자동차 대수는 몇 대 인가요?";
    private static final String secondRequest = "시도할 회수는 몇 회 인가요?";
    private static List<CarModel> carModelList;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        carModelList = new ArrayList<>();
        printByRequest(firstRequest);
        if (scanner.hasNext()) {
            createCarByNumber(intValueByScanner(scanner.next()));
        }
        printByRequest(secondRequest);
        if (scanner.hasNext()) {
            tryRacingByCar(intValueByScanner(scanner.next()));
        }
        scanner.close();
    }

    private static int intValueByScanner(String scannerValue) {
        int intValue = toInt(scannerValue);
        printByRequest(scannerValue);
        return intValue;
    }

    private static void printByRequest(String request) {
        System.out.println(request);
    }

    private static int toInt(String inputValue) {
        validByNumberCheck(inputValue);
        return Integer.parseInt(inputValue);
    }

    private static void validByNumberCheck(String inputValue) {
        String regExp = "^\\d+$";
        if (!inputValue.matches(regExp)) {
            throw new IllegalArgumentException("해당 문자는 숫자만 사용 가능합니다.");
        }
    }

    private static void createCarByNumber(int totalCarNumber) {
        for (int i = 0; i < totalCarNumber; i++) {
            CarModel carModel = new CarModel(i + 1);
            carModelList.add(carModel);
        }
    }

    private static void tryRacingByCar(int tryraceNumber) {
        for (int i = 0; i < tryraceNumber; i++) {
            racing();
        }
    }

    private static void racing() {
        int carModelNumber = carModelList.size();
        for (CarModel carModel : carModelList) {
            String carRaceResult = calculatorDistance(carModel.getRaceDistance());
            carModel.setRaceDistance(carRaceResult);
            printByRequest(carModel.getRaceDistance());
        }
        System.out.println();
    }

    private static String calculatorDistance(String raceDistance) {
        int randomNUmber = randomIntValue();
        String result = nullToBlank(raceDistance) + getRaceDistance(randomNUmber);
        return result.trim();
    }

    private static String nullToBlank(String raceDistance) {
        return raceDistance == null ? "" : raceDistance;
    }

    public static String getRaceDistance(int randomNUmber) {
        String distance = "";
        if (randomNUmber > 3) {
            distance = "-";
            return distance;
        }
        return distance;
    }

    public static int randomIntValue() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public List<CarModel> getCarList() {
        return carModelList;
    }
}
