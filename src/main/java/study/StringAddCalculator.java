package study;


/**
 * 문자를 구분하라.
 *     => 쉼포, 콜론을 통해서 구분할 수 있다.
 *     => 커스텀 문자를 통해서 구분할 수 있다.
 * 문자를 숫자로 변환하라
 *     => 숫자 이외의 값이 포함되어 있으면 RuntimeException을 발생시킨다.
 * 합을 계산하라.
 *     => 합을 계산한다.
 */
public class StringAddCalculator {

  private static final Separator separator;
  private static final Converter converter;

  static {
    separator = new Separator();
    converter = new Converter();
  }


  public static int splitAndSum(String text) {
    String[] chars = separator.split(text);

    int[] nums = converter.convert(chars);

    return sum(nums);
  }

  private static int sum(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    return sum;
  }
}
