package carRacingWinner.repository;

import carRacingWinner.entity.Car;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class WinnerRepository {

    private List<Car> names;
    private int tryCount;
    private final String display = "-";

    public void makeCars(String[] words) {
        names = new ArrayList<>();
        for (String word : words) {
            names.add(new Car(word));
        }
    }

    public void tryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void currentLocation() {
        for (Car name : names) {
            showCar(name);
        }
        System.out.println();
    }

    private void showCar(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getLocation(); i++) {
            System.out.print(display);
        }
        System.out.println();
    }

    public void carMove() {
        for (Car name : names) {
            moveCheck(name);
        }
    }

    private void moveCheck(Car car) {
        Random random = new Random();
        if (random.nextInt(10) > 5)
            car.move();
    }

    public void startPoint() {
        System.out.println("실행 결과");
        for (Car name : names) {
            name.move();
        }
        currentLocation();
    }

    public void finalWinner() {
        int winLocation = maxLocation();
        winners(winLocation);
    }

    private void winners(int location) {
        List<String> winners = new LinkedList<>();
        for (Car name : names) {
            if (name.getLocation() == location)
                winners.add(name.getName());
        }
        printResult(winners);
    }

    private void printResult(List<String> list) {

        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.print(list.get(list.size() - 1) + "가 최종 우승했습니다.");
    }

    private int maxLocation() {
        int max = 0;
        for (Car name : names) {
            if (max < name.getLocation())
                max = name.getLocation();
        }
        return max;
    }
}
