package race;

import java.util.*;

public class Cars {

    private static Map<String, Car> carMap = new HashMap<>();

    public Cars() {
    }

    public Cars(Map<String, Car> carMap) {
        this.carMap = carMap;
    }

    public static Cars createCarMap(int carCount) {
        for (int i = carCount; i > 0; i--) {
            Car car = new Car();
            carMap.put("name", car);
        }
        return new Cars();
    }

    protected final Map<String, Car> getCarMap() {
        return Collections.unmodifiableMap(carMap);
    }

    protected Cars moveCars(Cars cars, MoveCondition moveCondition) {
        for (Map.Entry<String, Car> carEntry : cars.getCarMap().entrySet()) {
            carEntry.getValue().addDistance(moveCondition);
        }
        return cars;
    }

}
