package racingcar.service;

import java.util.*;

public class RacingCarService {

    // 자동차 번호와 상태를 저장
    private static final Map<Integer,String> carMovementStatuses = new HashMap<>();

    public int[] generateRandomNumberForMovingCar(int numberOfCars) {
        Random random = new Random();

        int[] randomNumbers = new int[numberOfCars];

        // 입력받은 자동차 대수 만큼 랜덤한 값을 발생시킴
        for(int i = 0; i < numberOfCars; i++)
            randomNumbers[i] = random.nextInt(9) + 1; // 1부터 9까지의 랜덤한 숫자 발생

        return  randomNumbers;
    }

    public boolean[] isMovingForward(int[] randomNumbers) {
        boolean[] carForwardStatuses = new boolean[randomNumbers.length];

        for(int i = 0; i < randomNumbers.length; i++) {
            if(randomNumbers[i] >= 4)
                carForwardStatuses[i] = true;
        }

        return carForwardStatuses;
    }

    public void saveCarMovementStatuses(boolean[] carForwardStatuses) {
        for(int i = 0; i < carForwardStatuses.length; i++) {
            if(carMovementStatuses.get(i) == null) {
                carMovementStatuses.put(i, carForwardStatuses[i] ? "-" : "");
                continue;
            }

            carMovementStatuses.put(i, carMovementStatuses.get(i) + (carForwardStatuses[i] ? "-" : ""));
        }
    }

    public Map<Integer, String> getCarMoveStatuses() {
        return carMovementStatuses;
    }
}
