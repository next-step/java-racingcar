import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarFactory {
    public static Cars generateCars(int numberOfCars) {
        return new Cars(Stream.generate(Car::new)
                .limit(numberOfCars)
                .collect(Collectors.toList()));
    }
}
