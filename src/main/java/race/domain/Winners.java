package race.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<String> winners = new ArrayList<>();

    public void findWinners(Cars cars){
        for (Car car : cars.getCars()) {
            addWinners(cars, car);
        }
    }

    private void addWinners(Cars cars, Car car) {
        if(car.getPosition() == cars.getMaxPosition()) winners.add(car.getName());
    }

    public String getWinners() {
        return String.join(",", winners);
    }
    
}
