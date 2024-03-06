package step2;

import java.util.Collection;
import java.util.Iterator;

public class Delimiters {
  private final Collection<String> delimiters;

  public Delimiters(Collection<String> delimiters) {
    this.delimiters = delimiters;
  }

  public void add(String delimiter) {
    if ("".equals(delimiter)) {
      return;
    }
    this.delimiters.add(delimiter);
  }

  public String getCombinedDelimiter() {
    StringBuilder sb = new StringBuilder();
    this.delimiters.forEach(delimiter -> sb.append(delimiter.concat("|")));
    return sb.substring(0, sb.length() - 1);
  }
}
