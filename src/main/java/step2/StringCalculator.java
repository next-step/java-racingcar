package step2;

import static step2.CalculatorUtil.checkNullAndEmpty;

import java.util.List;
import java.util.Scanner;

public class StringCalculator {

  public static void main(String[] args) {
    //문자열 입력
    Scanner scanner = new Scanner(System.in);
    System.out.println("계산할 값은?");
    String input = scanner.nextLine();

    //입력 값 검증
    checkNullAndEmpty(input);

    String[] expression = input.split(" ");

    //문자열 분리
    StringSeparator separation = new StringSeparator(expression);
    List<Integer> numbers = separation.getNumbers();
    List<String> symbols = separation.getSymbols();

    //계산기 호출
    StringCalculator calculator = new StringCalculator();
    int result = calculator.callCalculator(numbers, symbols);
    System.out.println("계산 결과는?" + result);
  }

  public int callCalculator(List<Integer> numbers, List<String> symbols) {
    int result = numbers.get(0);
    int symbolIndex = 0;
    for (int i = 1; i < numbers.size(); i++) {
      for (Calculator calculator : Calculator.values()) {
        if (symbols.get(symbolIndex).equals(calculator.getSymbol())) {
          result = calculator.calculate(result, numbers.get(i));
        }
      }
      symbolIndex++;
    }
    return result;
  }
}
