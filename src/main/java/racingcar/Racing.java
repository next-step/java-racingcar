package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Racing {

    public List<Car> makeCars(int number) {
        return Stream.generate(Car::new)
                .limit(number)
                .collect(Collectors.toList());
    }


}
