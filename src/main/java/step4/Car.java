package step4;

public class Car {
  private final String name;
  private int position;

  private Car (final String name, final int position) {
    validatePosition(position);
    this.position = position;
    this.name = name;
  }

  public void going (int n) {
    this.position += n;
  }

  public int getPosition () {
    return this.position;
  }

  public String getName () {
    return this.name;
  }

  public String toString () {
    String str = this.name + " : ";
    for (int i = 0; i < this.position; i++) str += "-";
    return str;
  }

  public static Car of (String name, int position) {
    return new Car(name, position);
  }

  public static Car of (String name) {
    return new Car(name, 0);
  }

  public static Car of (int position) {
    return new Car("Car", position);
  }

  public static void validatePosition (int position) {
    if (position < 0) throw new IllegalArgumentException("자동차의 위치는 0 이상만 가능합니다.");
  }
}
