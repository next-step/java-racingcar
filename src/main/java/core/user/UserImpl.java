package core.user;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserImpl implements UserInterface {

  @Override
  public List<String> getCarNames() {
    String userCarNamesCmd = null;
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    do {
      Scanner sc = new Scanner(System.in);
      userCarNamesCmd = sc.nextLine();
    } while(isUserCarNameCmdValidate((userCarNamesCmd)));

    return parseCarNames(userCarNamesCmd);
  }

  @Override
  public Boolean isUserCarNameCmdValidate(String userCarNamesCmd) {
    if (!checkComma(userCarNamesCmd)) {
      return false;
    }
    List<String> carNames = parseCarNames(userCarNamesCmd);
    return checkCarNameLength(carNames);
  }

  @Override
  public Boolean checkCarNameLength(List<String> carNames) {
    for (String car : carNames) {
      if (5 >= car.length()) {
        continue;
      }
      System.out.println("[ERROR] 모든 자동차 이름은 5글자 이하여야합니다.");
      return false;
    }
    return true;
  }

  @Override
  public Boolean checkComma(String userCarNamesCmd) {
    if (isCommaInStartOrEnd(userCarNamesCmd)) {
      return false;
    }
    try {
      String[] carNames = userCarNamesCmd.split(",");
      if (isCarNameEmpty(carNames)) {
        return false;
      }
    } catch (InputMismatchException e) {
      System.out.println("쉼표(,) 사용을 정확히 해주세요");
      return false;
    }
    return true;
  }

  private static boolean isCarNameEmpty(String[] carNames) {
    for (String carName : carNames) {
      String trimmedPart = carName.trim();
      if (trimmedPart.isEmpty()) {
        System.out.println("자동차 이름이 비어있습니다.");
        return true;
      }
    }
    return false;
  }

  private static boolean isCommaInStartOrEnd(String userCarNamesCmd) {
    if (userCarNamesCmd.startsWith(",") || userCarNamesCmd.endsWith(",")) {
      System.out.println("자동차 이름 입력을 쉼표(,) 로 시작하거나 끝나면 안됩니다.");
      return true;
    }
    return false;
  }

  @Override
  public List<String> parseCarNames(String userCarNamesCmd) {
    List<String> carNames = Arrays.asList(userCarNamesCmd.split(","));
    for (String carName : carNames) {
      String trimmedPart = carName.trim();
      carNames.add(trimmedPart);
    }
    return carNames;
  }
}
