package step2;

import java.util.Collection;
import java.util.Iterator;

public class Delimiters implements Iterable<String> {
  private final Collection<String> delimiters;

  private int cursor;

  public Delimiters(Collection<String> delimiters) {
    this.delimiters = delimiters;
  }

  public void add(String delimiter) {
    if (delimiter != null) {
      this.delimiters.add(delimiter);
    }
  }

  @Override
  public Iterator<String> iterator() {
    return this.delimiters.iterator();
  }
}
