package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    Cars(int number) {
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
    }

    public int countCars() {
        return cars.size();
    }

    public void go() {
        for (Car car : cars) {
            car.go();
        }
    }

    public List<Integer> getScores() {
        return cars.stream().map(Car::getScore)
                .collect(Collectors.toList());
    }


    private static class Car {
        private int score;

        Car() {
            score = 0;
        }

        void go() {
            RandomUtil randomUtil = new RandomUtil();
            if (randomUtil.getRandomInt() > 4) {
                this.score++;
            }
        }

        int getScore() {
            return this.score;
        }
    }
}
