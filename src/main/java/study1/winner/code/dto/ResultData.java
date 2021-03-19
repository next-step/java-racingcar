package study1.winner.code.dto;

public class ResultData {
  private final String name;
  private final int distance;

  public ResultData(String name, int distance) {
    this.name = name;
    this.distance = distance;
  }

  public String name() {
    return name;
  }
  
  public int distance() {
    return distance;
  }
}
