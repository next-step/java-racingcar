package step2;

import java.util.Collection;
import java.util.Iterator;

public class Delimiters {
  private final Collection<String> delimiters;
  private final int LENGTH_OF_EXTRA_DIVIDER = 1;

  public Delimiters(Collection<String> delimiters) {
    this.delimiters = delimiters;
  }

  public void add(String delimiter) {
    if (delimiter.isEmpty()) {
      return;
    }
    this.delimiters.add(delimiter);
  }

  public String getCombinedDelimiter() {
    StringBuilder sb = new StringBuilder();
    this.delimiters.forEach(delimiter -> sb.append(delimiter.concat("|")));
    return removeExtraDivider(sb);
  }

  private String removeExtraDivider(StringBuilder sb) {
    return sb.substring(0, sb.length() - LENGTH_OF_EXTRA_DIVIDER);
  }
}
