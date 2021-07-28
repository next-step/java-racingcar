package step3.domain;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;

public class Racing {

  public List<Result> race(final Input input) {
    final Cars cars = new Cars(input.getNames());

    return IntStream.range(0, input.getNumberOfAttempts())
        .peek(i -> cars.move())
        .mapToObj(i -> new Result(
            cars.getCars().stream()
                .map(car -> new Car(car.getName(), car.getLocation()))
                .collect(toList())
        ))
        .collect(toList());
  }

}
