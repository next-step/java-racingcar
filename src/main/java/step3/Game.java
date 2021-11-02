package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private static final Random random = new Random();
    private final Long time;
    private final List<Car> cars = new ArrayList<>();

    private Game(Long time) {
        this.time = time;
    }

    public static Game of(RuleDto ruleDto) {
        InputValidator.isNull(ruleDto.getCount());
        InputValidator.isNull(ruleDto.getTime());

        return new Game(ruleDto.getTime());
    }

//    public void start() {
//        for(int i = 0; i < time; i++) {
//            step();
//            printCars();
//        }
//    }
//
//    private void printCars() {
//        cars.stream()
//                .forEach(Car::printNow);
//    }

    private void step() {
        cars.stream()
                .forEach(car -> car.moveOrStop(random.nextInt(10)));
    }
}
