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
    private int totalCarNumber = 0;
    private int tryraceNumber = 0;

    public Car() {
        this.scanner = new Scanner(System.in);
        this.carModelList = new ArrayList<>();
    }


    public void car_racing() {
        System.out.println(firstRequest);
        if (scanner.hasNextLine()) {
            totalCarNumber = scanner.nextInt();
            createCarByNumber(totalCarNumber);
        }
        if (scanner.hasNextLine()) {
            tryraceNumber = scanner.nextInt();
            tryRacingByCar(tryraceNumber);
        }
        scanner.close();
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
        for (int i = 0; i < carModelNumber; i++) {
            String carRaceResult = calculatorDistance(carModelList.get(i).getRaceDistance());
            carModelList.get(i).setRaceDistance(carRaceResult);
            System.out.println(carModelList.get(i).getRaceDistance());
        }
        System.out.println();
    }

    private String calculatorDistance(String raceDistance) {
        int randomNUmber = randomIntValue();
        String result = raceDistance + getRaceDistance(randomNUmber);
        return result.trim();
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
        int result = random.nextInt(10);
        return result;
    }

    public List<CarModel> getCarList() {
        return carModelList;
    }
}
