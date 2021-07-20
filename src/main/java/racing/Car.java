package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Car {

    private final Scanner scanner;

    private final String firstRequest = "자동차 대수는 몇 대 인가요?";
    private final String secondRequest = "시도할 회수는 몇 회 인가요?";
    private List<CarModel> carModelList;

    public Car() {
        this.scanner = new Scanner(System.in);
        this.carModelList = new ArrayList<>();
    }

    private void printByRequest(String request) {
        System.out.println(request);
    }

    private int intValueByScanner(String scannerValue) {
        int intValue = toInt(scannerValue);
        printByRequest(scannerValue);
        return intValue;
    }

    public void car_racing() {
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

    private int toInt(String inputValue) {
        validByNumberCheck(inputValue);
        return Integer.parseInt(inputValue);
    }

    private void validByNumberCheck(String inputValue) {
        String regExp = "^[0-9]+$";
        if (!inputValue.matches(regExp)) {
            throw new IllegalArgumentException("해당 문자는 숫자만 사용 가능합니다.");
        }
    }


    private void createCarByNumber(int totalCarNumber) {
        for (int i = 0; i < totalCarNumber; i++) {
            CarModel carModel = new CarModel(i + 1);
            carModelList.add(carModel);
        }
    }

    private void tryRacingByCar(int tryraceNumber) {
        for (int i = 0; i < tryraceNumber; i++) {
            racing();
        }
    }

    private void racing() {
        int carModelNumber = carModelList.size();
        for(CarModel carModel : carModelList){
            String carRaceResult = calculatorDistance(carModel.getRaceDistance());
            carModel.setRaceDistance(carRaceResult);
            printByRequest(carModel.getRaceDistance());
        }
        System.out.println();
    }

    private String calculatorDistance(String raceDistance) {
        int randomNUmber = randomIntValue();
        String result = nullToBlank(raceDistance) + getRaceDistance(randomNUmber);
        return result.trim();
    }

    private String nullToBlank(String raceDistance) {
        return raceDistance == null ? "" : raceDistance;
    }

    public String getRaceDistance(int randomNUmber) {
        String distance = "";
        if (randomNUmber > 3) {
            distance = "-";
            return distance;
        }
        return distance;
    }

    public int randomIntValue() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public List<CarModel> getCarList() {
        return carModelList;
    }
}
