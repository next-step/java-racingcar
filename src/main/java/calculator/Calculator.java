package calculator;

public class Calculator {

  public static int calculate(String text) {
    // Indent 1까지만 허용하고 그 이상을 리팩토링 대상으로 보자
    // Indent를 줄이는 방법은 메소드로 추출하는 것이다.
    // Indent 정말 최대 2까지 하고 그 이후는 stream, lambda를 사용해서 리팩토링 해보자
    // stream, lambda 처음부터 남발하면 OOP 연습하기 어렵다.
    // 코드가 2N 이기는 하지만, 성능에 크게 무리가 없으며, 문제가 있으면 그때 합치면 된다.

    if (isBlank(text)) {
      return 0;
    }
    return sum(toInts(split(text)));
  }

  private static boolean isBlank(String text) {
    return text == null || text.isEmpty();
  }

  private static String[] split(String text) {
    return text.split(",|:");
  }

  private static int sum(int[] numbers) {
    int result = 0;
    for (int number : numbers) {
      result += number;
    }
    return result;
  }

  private static int[] toInts(String[] values) {
    int[] numbers = new int[values.length];
    for (int i = 0; i < values.length; i++) {
      numbers[i] = Integer.parseInt(values[i]);
    }
    return numbers;
  }

}
