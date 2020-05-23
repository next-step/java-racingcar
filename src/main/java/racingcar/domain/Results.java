package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Results {

  private List<String> results = new ArrayList<>();

  public Results() {}

  private Results(List<String> results) {
    this.results = results;
  }

  public List<String> getResults() {
    return results;
  }

  public String getLastestResult() {
    int lastestIndex = this.results.size() - 1;
    return this.results.get(lastestIndex);
  }

  public List<String> updateResults(String currentView) {
    this.results.add(currentView);
    return this.results;
  }

  public static Results create() {
    return new Results();
  }

  public static Results create(List<String> results) {
    return new Results(results);
  }
}
