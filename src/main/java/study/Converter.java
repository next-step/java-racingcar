package study;

public class Converter {

  public PositiveNumber convert(String[] chars) {
    int length = chars.length;

    int[] nums = new int[length];
    for (int i = 0; i < length; i++) {
      nums[i] = toInt(chars[i]);
    }
    return new PositiveNumber(nums);
  }

  private int toInt(String chars) {
    return Integer.parseInt(chars);
  }
}
