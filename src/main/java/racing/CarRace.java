package racing;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarRace {

    private List<Car> cars = new ArrayList<Car>();
    private List<Car> winners = new ArrayList<>();

    List<Car> getCars() {
        return cars;
    }

    int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(9);
    }

    void racing() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move(getRandomNumber());
            display(cars.get(i));
        }
        System.out.println();
    }

    void display(final Car car) {
        System.out.print(car.getName() + ':');
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    void getWinners() {
        int maxPosition;

        Comparator<Car> comparatorByPosition = Comparator.comparingInt(Car::getPosition);

        maxPosition = cars.stream().max(comparatorByPosition).orElseThrow().getPosition();

        winners = cars.stream()
                .filter(p -> p.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    void winnersDisplay() {
        System.out.print("최종 우승자 : ");
        winners.stream()
                .forEach(name -> System.out.print(name.getName() + ", "));
    }
}
