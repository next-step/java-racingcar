package CarRacingGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CarRacingGameUtils {
    public Map<String, String> cars;

    //    TODO. 초기 차 인풋을 받고 차의 이동거리가 1인 상태에서 시작하는지,
    //     차의 이동거리가 0 인상태에서 시작되는 것인지 확인 필요
    public Map<String, String> initialCarSettings(Integer numberOfCars) {
        cars = new HashMap<>();
        for (int carNum = 1; carNum <= numberOfCars; carNum++) {
            cars.put("car" + carNum, "-");
        }
        return cars;
    }

    public void printMovingCars(int numberOfAttempts) {
        System.out.println("실행 결과");
        for (int attempt = 0; attempt < numberOfAttempts; attempt++) {
            PrintView.printCars(cars);
            moveCars();
            System.out.println();
        }
    }

    public void moveCars() {
        cars.forEach((carNumber, currentPosition) -> {
            String newPosition = makeDistanceOfCars(currentPosition);
            cars.put(carNumber, newPosition);
        });
    }

    public String makeDistanceOfCars(String currentPosition) {
        Random random = new Random();
        int randomValue = random.nextInt(10);
        if (randomValue >= 4) {
            currentPosition += "-";
        }
        return currentPosition;
    }
}
