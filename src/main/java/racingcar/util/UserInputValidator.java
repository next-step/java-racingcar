package racingcar.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInputValidator {

  private static final int MAX_NAME_LENGTH = 5;

  public List<String> carNameValidation(String readLine) {
    String[] splitCarName = readLine.split(",");
    carNameIsProperlySplit(splitCarName.length);
    removeWhiteSpace(splitCarName);
    hasStrangeName(splitCarName);
    hasDuplicatedName(splitCarName);
    return Arrays.asList(splitCarName);
  }

  public String inputRoundValidation(String round) {
    if(isNumeric(round)){
      return round;
    }
    throw new IllegalArgumentException("ERROR : 숫자만 입력하실 수 있습니다.");
  }

  private void hasStrangeName(String[] splitCarName) {
    for(String carName : splitCarName){
      isOverMaxLength(carName);
      isContainNotAlphabet(carName);
    }
  }

  private void removeWhiteSpace(String[] splitCarName) {
    for(int i = 0; i < splitCarName.length; i++) {
      splitCarName[i] = splitCarName[i].replaceAll("\\s+","");
    }
  }

  private void hasDuplicatedName(String[] carNames) {
    Set<String> tempSet = new HashSet<>();
    Collections.addAll(tempSet, carNames);
    if(tempSet.size() != carNames.length){
      throw new IllegalArgumentException("ERROR : 중복된 이름을 입력할 수 없습니다.");
    }
  }

  private void isContainNotAlphabet(String carName) {
    if(!carName.matches("[a-zA-Z]+")){
      throw new IllegalArgumentException("ERROR : 이름에 숫자나 특수문자를 포함시킬 수 없습니다.");
    }
  }

  private void isOverMaxLength(String carName) {
    if(carName.length() > MAX_NAME_LENGTH) {
      throw new IllegalArgumentException("ERROR : 이름을 5자를 초과할 수 없습니다.");
    }
  }

  private void carNameIsProperlySplit(int splitSize) {
    if(splitSize <= 0) {
      throw new IllegalArgumentException("ERROR : 잘못 입력하셨습니다.");
    }
  }

  private boolean isNumeric(String str) {
    return str.matches("-?\\d+(\\.\\d+)?");
  }
}
