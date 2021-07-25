package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int GO_CONDITION = 4;
    private final List<Car> cars = new ArrayList<>();

    public Cars(int number) {
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }
    }

    public int countCars() {
        return cars.size();
    }

    public void attempt() {
        for (Car car : cars) {
            RandomUtil randomUtil = new RandomUtil();
            if (randomUtil.getRandomInt() > GO_CONDITION) {
                car.go();
            }
        }
    }

    public List<Integer> getScores() {
        return cars.stream().map(Car::getScore)
                .collect(Collectors.toList());
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(Car car: cars){
            result.append(car.toString()).append("\n");
        }
        return result.toString();
    }


    private static class Car {
        private int score;

        Car() {
            score = 0;
        }

        void go() {
            score++;
        }

        int getScore() {
            return this.score;
        }

        @Override
        public String toString(){
            StringBuilder result = new StringBuilder();
            for(int i=0; i<score; i++){
                result.append("-");
            }
            return result.toString();
        }
    }
}
