package raingcar;

import java.util.ArrayList;

public class RacingStatus {
    public RacingStatus () {

    }

    private String displayDistance(RacingCar car) {
        StringBuilder distance = new StringBuilder();
        for (int ii = 0; ii < car.getMoveDistance(); ii++)
            distance.append("-");
        return distance.toString();
    }
    public void displayCars(ArrayList<RacingCar> cars) {
        for (RacingCar car: cars) {
            System.out.println(car.getName() + " : "+displayDistance(car));
        }
    }

    public void displayWiner(ArrayList<RacingCar> cars) {
        System.out.println("Winner");
        for (RacingCar car: cars) {
            System.out.println(car.getName());
        }
    }
}
