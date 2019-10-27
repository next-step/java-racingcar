package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {


  static List operatorList = Stream.of(Operator.values())
      .map(m -> m.getName())
      .collect(Collectors.toList());

  public static long plus(long first, long second) {
    return first + second;
  }

  public static long minus(long first, long second) {
    return first - second;
  }

  public static long multiply(long first, long second) {
    return first * second;
  }

  public static long divide(long first, long second) {
    return first / second;
  }

  public static void validateTextFormatArgs(String[] args){
    if(args.length < 3 || (args.length % 2) == 0){
      throw new IllegalArgumentException("올바르지 않은 연산자가 입력되었습니다.");
    }
  }


  public static long calculate(String operator, long first, long second){
    if(operatorList.indexOf(operator) == -1){
      throw new IllegalArgumentException("올바르지 않은 연산자가 입력되었습니다.");
    }

    Long result = 0L;
    if(operator.equals(Operator.PLUS_OPERATOR.getName())){
      result = plus(first, second);
    }
    if(operator.equals(Operator.MINUS_OPERATOR.getName())){
      result = minus(first, second);
    }
    if(operator.equals(Operator.MULTIPLY_OPERATOR.getName())){
      result = multiply(first, second);
    }
    if(operator.equals(Operator.DIVIDE_OPERATOR.getName())){
      result = divide(first, second);
    }

    return result;
  }

  public static long run(String arg){
    if(arg == null || arg.equals("") || arg.length() == 0){
      throw new IllegalArgumentException("문자열이 입력되지 않았습니다.");
    }

    String[] args = arg.split(" ");
    validateTextFormatArgs(args);
    long result = Long.parseLong(args[0]);
    Long target = 0L;
    for(int i=0; i<args.length-2; i++){
      if(i%2 != 0) i++;
      target = Long.parseLong(args[i+2]);
      result = calculate(args[i+1], result, target);
    }
    return result;
  }

}
