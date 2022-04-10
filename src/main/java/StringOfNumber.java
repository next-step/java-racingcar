/*
  사용 빈도수가 높을 것 같은 value의 StringOfNumber는 Integer처럼 cache를 사용하거나
  static으로 몇몇 인스턴스를 미리 만들어서 반환하는 형식도 좋을 것 같다.
 */
public class StringOfNumber {

  /*
  클래스명은 StringOfNumber임에도 불구하고 내부 필드를 int로 가지고 있는 이유는, String이라는 타입은
  입출력에서만 사용되고 실제로 다룰 때는 int 타입으로 다뤄질 것이기 기문에 int로 선언함.
   */
  private final int intValue;

  private StringOfNumber(int intValue) {
    if (intValue < 0) {
      throw new RuntimeException("음수는 허용되지 않습니다.");
    }
    this.intValue = intValue;
  }

  public int toInt() {
    return intValue;
  }

  public String toString() {
    return String.valueOf(intValue);
  }

  public static StringOfNumber valueOf(String text) {
    return new StringOfNumber(Integer.parseInt(text));
  }
}
