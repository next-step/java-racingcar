package racing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

public class Winners {
    
    public static ArrayList<String> getWinner(RacingCars cars) {
        ArrayList<RacingCar> carList = (ArrayList)cars.getRecingCarList();
        int max = carList.stream().max(Comparator.comparing(RacingCar::getRacingResult))
                                  .map(RacingCar::getRacingResult)
                                  .get();

        return carList.stream().filter(car -> car.getRacingResult() == max)
                               .map(car -> car.getName())
                               .collect(toCollection(ArrayList::new));
    }
}
