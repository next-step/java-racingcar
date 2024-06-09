package core.user;

import core.util.Util;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserImpl implements UserInterface {

  static Util util = new Util();
  public UserImpl() {
  }

  @Override
  public List<String> getCarNames() {
    String userCarNamesCmd = null;
    util.printMsg("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    do {
      Scanner sc = new Scanner(System.in);
      userCarNamesCmd = sc.nextLine();
    } while (!isUserCarNameCmdValidate((userCarNamesCmd)));

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
      util.printErrorMsg("모든 자동차 이름은 5글자 이하여야합니다.");
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
      util.printErrorMsg("쉼표(,) 사용을 정확히 해주세요");
      return false;
    }
    return true;
  }

  private static boolean isCarNameEmpty(String[] carNames) {
    for (String carName : carNames) {
      String trimmedPart = carName.trim();
      if (trimmedPart.isEmpty()) {
        util.printErrorMsg("자동차 이름이 비어있습니다.");
        return true;
      }
    }
    return false;
  }

  private static boolean isCommaInStartOrEnd(String userCarNamesCmd) {
    if (userCarNamesCmd.startsWith(",") || userCarNamesCmd.endsWith(",")) {
      util.printErrorMsg("자동차 이름 입력을 쉼표(,) 로 시작하거나 끝나면 안됩니다.");
      return true;
    }
    return false;
  }

  @Override
  public List<String> parseCarNames(String userCarNamesCmd) {
    String[] carNames = userCarNamesCmd.split(",");
    List<String> returnList = new ArrayList<String>();
    for (String carName : carNames) {
      String trimmedPart = carName.trim();
      returnList.add(trimmedPart);
    }
    return returnList;
  }

  @Override
  public Integer getGameTimes() {
    String userGameTimesCmd = null;
    util.printMsg("시도할 회수는 몇회인가요?");
    do {
      Scanner sc = new Scanner(System.in);
      userGameTimesCmd = sc.nextLine();
    } while (!isGameTimeValidate((userGameTimesCmd)));

    return Integer.parseInt(userGameTimesCmd);
  }

  private boolean isGameTimeValidate(String userGameTimesCmd) {
    try {
      int gameTime = Integer.parseInt(userGameTimesCmd);
      if (0 >= gameTime) {
        util.printErrorMsg("양의 정수를 입력하세요");
        return false;
      }
    } catch (NumberFormatException e) {
      util.printErrorMsg("2147483647 이하의 숫자만 입력하십시오");
      return false;
    }
    return true;
  }
}
