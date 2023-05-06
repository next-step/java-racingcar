package study.dto;

public class InputDto {
  private String carsStr;
  private int tryCount;

  public InputDto(String carsStr, int tryCount) {
    this.carsStr = carsStr;
    this.tryCount = tryCount;
  }

  public String getCarsStr() {
    return carsStr;
  }

  public int getTryCount() {
    return tryCount;
  }
}
