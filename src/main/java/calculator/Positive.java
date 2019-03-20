package calculator;

public class Positive {

  private int no;

  public Positive(int no) {

    if (no < 0) {
      throw new RuntimeException();
    }
    this.no = no;
  }

  public Positive add(int no) {
    return new Positive(this.no + no);
  }
}
