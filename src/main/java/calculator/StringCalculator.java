package calculator;

import java.util.*;
import java.util.stream.Stream;

public class StringCalculator {

  public int calculate(String formula){
    nonEmpty(formula, "Formula is null");
    String[] splittedData = formula.split(" ");
    int result = convertStringToInt(splittedData[0]);
    for(int i=1; i<splittedData.length; i+=2){
      result = executeOper(result, splittedData[i], convertStringToInt(splittedData[i+1]));
    }

    return result;
  }

  private int executeOper(int numA, String operator, int numB){

    if(operator.equals("+")) return plus(numA, numB);
    if(operator.equals("-")) return minus(numA, numB);
    if(operator.equals("*")) return multiple(numA, numB);
    if(operator.equals("/")) return divide(numA, numB);

    throw new IllegalArgumentException("Operator Error");
  }

  private void nonEmpty(String target, String errorMessage){
    if(target.trim().isEmpty() || target==null){
      throw new IllegalArgumentException("Target String is empty.");
    }
  }

  /** String -> int 변환 */
  private int convertStringToInt(String target){
    try {
      return Integer.parseInt(target);
    } catch(Exception e) {
      throw new IllegalArgumentException("Can not convert to Integer");
    }
  }

  private int plus(int numA, int numB){
    return numA+numB;
  }

  private int minus(int numA, int numB){
    return numA-numB;
  }

  private int multiple(int numA, int numB){
    return numA*numB;
  }

  private int divide(int numA, int numB){
    return numA/numB;
  }

}
