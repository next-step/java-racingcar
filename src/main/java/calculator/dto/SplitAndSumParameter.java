package calculator.dto;

import java.util.List;

public class SplitAndSumParameter {
  private final String argumentChunk;
  private final List<String> delimiterList;

  public SplitAndSumParameter(String argumentChunk, List<String> delimiterList) {
    this.argumentChunk = argumentChunk;
    this.delimiterList = delimiterList;
  }

  public String[] getArguments() {
    String delimiterRegEx = String.join("|", delimiterList);
    return argumentChunk.split(delimiterRegEx);
  }
}
