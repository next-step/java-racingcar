package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Record {

  private List<Position> record = new ArrayList<>();

  public void write(Position position) {
    record.add(position);
  }

  public List<Position> getRecord() {
    return record;
  }
}
