package step3;

import java.util.ArrayList;
import java.util.List;

import static step3.utils.ValidationUtils.checkArgument;

public class Engineer {

    private static final int CAR_DEFAULT_LOCATION = 0;

    public static List<Car> makeCar(Long carCount, Long goCount) {
        checkArgument(carCount != null, "carCount is required");
        checkArgument(goCount != null, "goCount is required");

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            Car car = createCar(goCount);
            car.fullAccelerate();
            cars.add(car);
        }
        return cars;
    }

    private static Car createCar(Long goCount) {
        OilTank oilTank = createOilTank(goCount);
        return new Car(oilTank, Location.createOn(CAR_DEFAULT_LOCATION));
    }

    private static OilTank createOilTank(Long goCount) {
        List<Material> materials = Material.createRandoms(goCount);
        return OilStation.createOilTank(materials);
    }

}
