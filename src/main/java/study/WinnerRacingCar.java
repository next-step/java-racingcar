package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WinnerRacingCar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String  carNames = scanner.nextLine();
        int moveCount = scanner.nextInt();
        WinnerRacingCar racingCar = new WinnerRacingCar();
        racingCar.race(racingCar.makeRacingCar(carNames), moveCount);
    }

    public void race(List<Car> cars, int moveCount) {
        System.out.println("실행결과");

        for (int i = 0; i <moveCount; i++) {
            for (Car car : cars) {
                car.move();
                car.print();
            }
            System.out.println("");
        }
        System.out.println(makeWinnerName(findWinnerCar(cars)) + "가 최종 우승 했습니다.");
    }


    public List<Car> makeRacingCar(String carNames) {
        String[] carNameArray = carNames.split(",");
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i <carNameArray.length ; i++) {
            cars.add(new Car(carNameArray[i]));
        }
        return cars;
    }

    public List<Car> findWinnerCar(List<Car> cars) {
        List<Car> winnerCars = new ArrayList<>();
        int maxPosition = maxPosition(cars);
        for (Car car : cars) {
            if(car.isWinner(maxPosition)){
                winnerCars.add(car);
            }
        }
        return winnerCars;
    }

    public int maxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.max(maxPosition);
        }
        return maxPosition;
    }

    public String makeWinnerName(List<Car> winnerCars) {
        ArrayList<String> winnerNames = new ArrayList<>();
        for (Car car : winnerCars) {
            winnerNames.add(car.getName());
        }
        return String.join(",", winnerNames);
    }
}
