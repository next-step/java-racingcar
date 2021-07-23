package step3;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;

public class Racing {

  private Cars cars;

  public List<Result> race(final Input input) {
    cars = new Cars(input.getNames());

    return IntStream.range(0, input.getNumberOfAttempts())
        .peek(i -> cars.move())
        .mapToObj(i -> new Result(cars.getCars()))
        .collect(toList());
  }

}
