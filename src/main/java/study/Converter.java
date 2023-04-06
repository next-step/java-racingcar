package study;

public class Converter {

  public int[] convert(String[] chars) {
    int length = chars.length;

    int[] nums = new int[length];
    for (int i = 0; i < length; i++) {
      nums[i] = toInt(chars[i]);
      validateNonNegative(nums, i);
    }
    return nums;
  }

  private int toInt(String chars) {
    return Integer.parseInt(chars);
  }

  private void validateNonNegative(int[] nums, int i) {
    if(nums[i] < 0) {
      throw new RuntimeException();
    }
  }
}
