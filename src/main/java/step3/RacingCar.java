package step3;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {

    public static final int RANDOM_LIMIT = 10;
    public static final int LIMIT = 4;
    public static final String MARK = "-";

    public void races(List<Car> cars, int count){
        for(int i=0; i<count; i++){
            for (Car car : cars) {
                boolean goStop = isValueMoreThan(randomValue());
                car.goOrStop(goStop);
            }
            for (Car car : cars) {
                for(int j = 0; j< car.getGoCount(); j++){
                    System.out.print(MARK);
                }
                System.out.println();
            }
            System.out.println();

        }
    }

    public boolean isValueMoreThan(int value) {
        return value >= LIMIT;
    }

    private int randomValue() {
        Random random = new Random();
        int value = random.nextInt(RANDOM_LIMIT);
        return value;
    }

    static List<Car> initCars(int car){
        List<Car> cars = new ArrayList<>();
        for(int i=0; i<car; i++){
            cars.add(new Car());
        }
        return cars;
    }

}
