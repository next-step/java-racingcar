package racingCar.step4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCars {

    private static final String CAR_NAME_SEPARATOR = ",";
    private static final int MOVE_CONDITION_LIMIT = 10;
    private static final Random MOVE_CONDITION_MAKER = new Random();

    private final List<RacingCar> cars;

    private RacingCars(List<RacingCar> cars){
        this.cars = cars;
    }

    public static RacingCars createCarsWithNames(String names){
        List<RacingCar> cars = new ArrayList<>();
        String[] nameArray = splitName(names);
        for (String name : nameArray) {
            RacingCar car = RacingCar.createCarWithName(name);
            cars.add(car);
        }
        return new RacingCars(cars);
    }

    private static String[] splitName(String names) {
        return names.split(CAR_NAME_SEPARATOR);
    }

    public void move() {
        for (RacingCar car : cars) {
            car.move(createMoveCondition());
        }
    }

    private int createMoveCondition(){
        return MOVE_CONDITION_MAKER.nextInt(MOVE_CONDITION_LIMIT);
    }

    public int getMaxCarPosition() {
        int maxCarPosition = 0;
        for (RacingCar car : cars) {
            maxCarPosition = Math.max(maxCarPosition, car.getPosition());
        }
        return maxCarPosition;
    }

    public List<RacingCar> findCarsByPosition(int maxCarPosition) {
        List<RacingCar> samePositionCars = new ArrayList<>();
        for (RacingCar car : cars) {
            if(car.isCurrentPosition(maxCarPosition)) samePositionCars.add(car);
        }
        return samePositionCars;
    }

    public List<RacingCar> getCars() {
        return cars;
    }
}

