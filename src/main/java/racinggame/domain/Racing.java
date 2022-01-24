package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    private static final int MAX_RANGE = 10;
    private static final int FORWARD_NUMBER = 4;

    private List<Car> cars = new ArrayList<>();
    private StringBuilder result = new StringBuilder("");

    public Racing(List<String> carNames, int tryCount) {
        registerCar(carNames);
        while (tryCount > 0) {
            move();
            calculateResult();
            tryCount--;
        }
    }

    private void registerCar(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(Car.of(carName));
        }
    }

    private void move() {
        for (Car car : cars) {
            int randomNumber = makeRandomNumber();
            if (randomNumber >= FORWARD_NUMBER) {
                car.moveForward();
            }
        }
    }

    private int makeRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_RANGE);
    }

    private void calculateResult() {
        for (Car car : cars) {
            result.append(car.getName() + " : ");
            for (int i = 0; i < car.getLocation(); i++) {
                result.append('-');
            }
            result.append("\n");
        }
        result.append("\n");
    }
    
//    public void printCarsLocation() {
//        for (Car car : cars) {
//            System.out.print(car.getName() + " : ");
//            for (int i = 0; i < car.getLocation(); i++) {
//                System.out.print('-');
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }


//    public int findMaxLocation() {
//        int maxLocation = 0;
//        for (Car car : cars) {
//            maxLocation = Math.max(car.getLocation(), maxLocation);
//        }
//        return maxLocation;
//    }
//
//    public List<String> findWinner() {
//        List<String> winnerUsers = new ArrayList<>();
//        int maxLocation = findMaxLocation();
//        for (Car car : cars) {
//            if (car.getLocation() == maxLocation) {
//                winnerUsers.add(car.getName());
//            }
//        }
//        return winnerUsers;
//    }
//
//    public void printWinner(List<String> winnerUsers) {
//        System.out.print("최종 우승자: ");
//        String winnerList = String.join(", ", winnerUsers);
//        System.out.println(winnerList);
//    }

}
