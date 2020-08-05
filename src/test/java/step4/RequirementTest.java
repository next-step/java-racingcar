package step4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RequirementTest {
    /**
     * pobi : -
     * crong : -
     * honux : -
     * <p>
     * pobi : --
     * crong : -
     * honux : --
     */
    @Test
    void requirementSketch() {
        String inputName = "pobi,crong,honux";
        int inputLaps = 5;
        int champion = 0;

        String[] names = inputName.split(",");
        List<CarSketch> cars = new ArrayList<>();
        for (String s : names) {
            cars.add(new CarSketch(s));
        }

        for (int i = 0; i < inputLaps; i++) {
            for (CarSketch a : cars) {
                a.upLocation();
                System.out.println(a.name + " : " + a.location);
                champion = champion > a.location
                    ? champion :
                    a.location;
            }
            System.out.println();
        }
        int finalChampion = champion;
        String msg = cars.stream()
                         .filter(car ->
                                     finalChampion == car.getLocation())
                         .map(CarSketch::getName)
                         .collect(Collectors.joining(","));
        System.out.println("win is : " + msg);
    }

    class CarSketch {
        private final Random generator = new Random();
        String name;
        int location = 1;

        public CarSketch(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getLocation() {
            return location;
        }

        public void upLocation() {
            this.location = 4 <= generator.nextInt(10)
                ? ++this.location
                : this.location;
        }
    }
}
