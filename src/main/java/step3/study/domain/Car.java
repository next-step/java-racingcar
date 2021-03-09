package step3.study.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String distance = "";
    private List<String> recodeDistance;
    private static int MOVE_CONDITION = 4;

    public Car() {
        recodeDistance = new ArrayList<>();
    }

    public void move(int randomNumber) {
        if (MOVE_CONDITION <= randomNumber) {
            this.distance += "-";
        }
        recodeDistance.add(this.distance);
    }

    public static List<Car> ofList(RequestRacingDTO requestRacingDTO) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < requestRacingDTO.getCarCount(); i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public List<String> getRecodeDistance() {
        return recodeDistance;
    }
}
