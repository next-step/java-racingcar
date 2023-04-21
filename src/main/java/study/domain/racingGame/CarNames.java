package study.domain.racingGame;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CarNames implements Iterable<String> {

  private List<String> value;

  public CarNames() {
    this.value = new LinkedList<String>();
  }

  public CarNames(String[] carNames) {
    this();
    if (isEmptyInputCarNames(carNames)) {
      return;
    }
    this.value.addAll(Arrays.asList(carNames));
  }

  private boolean isEmptyInputCarNames(String[] carNames) {
    return carNames == null || carNames.length == 0;
  }

  public void addName(String carName) {
    this.value.add(carName);
  }

  public boolean isEmpty() {
    return this.value.isEmpty();
  }

  @Override
  public Iterator<String> iterator() {
    return this.value.iterator();
  }
}
