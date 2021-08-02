package CarRacing;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class Winner {

    public static String printWinner(List<Car> cars) {
        Comparator<Car> comparatoryByPosition = Comparator.comparingInt(Car::getPosition);
        StringBuffer winner = new StringBuffer();
        Car winnerCar = cars.stream()
                .max(comparatoryByPosition)
                .orElseThrow(NoSuchElementException::new);
        IntStream
                .range(0, cars.size())
                .filter(i -> cars.get(i).getPosition() == winnerCar.getPosition())
                .forEach(i -> winner.append(cars.get(i).getCarName()).append(","));
        return winner.substring(0, winner.length() - 1);
    }

}
