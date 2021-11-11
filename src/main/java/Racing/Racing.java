package Racing;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Racing {

  static final private String TOKEN = "-";
  static final private String SPLIT_TOKEN = "\n";

  public String run(int countOfCar, int countOfBoard) {

    return getLongStream(countOfBoard)
        .mapToObj(i -> getCollect(countOfCar))
        .map(result -> result + SPLIT_TOKEN)
        .collect(Collectors.joining());
  }

  private String getCollect(int countOfCar) {
    return getLongStream(countOfCar)
        .mapToObj(innerElement -> TOKEN.repeat(getRandomToken()) + SPLIT_TOKEN)
        .collect(Collectors.joining());
  }

  private LongStream getLongStream(int endInclusive) {
    return LongStream.rangeClosed(1, endInclusive);
  }

  private int getRandomToken() {
    int i = 0;
    while (i == 0) {
      i = new Random().nextInt(10);
    }
    return i;
  }


}
