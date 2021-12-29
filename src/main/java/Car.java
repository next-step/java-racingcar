import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Car {
    public static List<String> cars = new ArrayList<>();
    public static List<String> carsMoving = new ArrayList<>();
    public static List<String> winner = new ArrayList<>();
    static final int CAR_NAME_LENGTH_BOUND = 5;
    static final int CAR_MOVE = 4;

    public void splitCarsName(String carsName) {
        String[] carsList = carsName.split(",");
        for (int i = 0; i < carsList.length; i++) {
            validateNameLengthCheck(carsList[i]);
            cars.add(carsList[i]);
            carsMoving.add("");
        }
    }

    public void validateNameLengthCheck(final String carName) {
        if (carName.length() > CAR_NAME_LENGTH_BOUND) {
            throw new IllegalArgumentException("car name is too long");
        }
    }

    public void carsMove(int carIndex, int randomNumber) {
        if (randomNumber >= CAR_MOVE) {
            String newMove = carsMoving.get(carIndex) + "-";
            carsMoving.set(carIndex, newMove);
        }
    }

    public int findMaxDistance() {
        int maxDistance = 0;
        for (int i = 0; i < cars.size(); i++) {
            int distance = carsMoving.get(i).length();
            maxDistance = checkMaxDistance(maxDistance, distance);
        }
        return maxDistance;
    }

    public int checkMaxDistance(int maxDistance, int distance) {
        if (distance > maxDistance) {
            return distance;
        }
        return maxDistance;
    }

    public void findMaxDistanceCar(int maxDistance) {
        for (int i = 0; i < cars.size(); i++) {
            int distance = carsMoving.get(i).length();
            isMaxDistanceCar(maxDistance, distance, i);
        }
    }

    public void isMaxDistanceCar(int maxDistance, int distance, int carIndex) {
        if (distance == maxDistance) {
            winner.add(cars.get(carIndex));
        }
    }
}
