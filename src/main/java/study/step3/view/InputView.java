package study.step3.view;

import study.step3.error.InvalidNameException;

import java.util.Scanner;

public class InputView {

  private static final Scanner SCANNER = new Scanner(System.in);
  private static final String QUESTION_NAME_OF_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  private static final String QUESTION_NUM_OF_ROUNDS = "시도할 회수는 몇 회 인가요?";

  private InputView() {
  }

  public static int inputNumOfRaces() {
    printQuestion(QUESTION_NUM_OF_ROUNDS);
    return intputNum();
  }

  public static String[] inputNameOfCars() {
    printQuestion(QUESTION_NAME_OF_CARS);
    return inputNames();
  }

  private static void printQuestion(String question) {
    System.out.println(question);
  }

  private static int intputNum() {
    int number = SCANNER.nextInt();

    validatePositiveNum(number);
    return number;
  }

  private static void validatePositiveNum(int number) {
    if (number <= 0) {
      throw new NumberFormatException("양의 정수가 아닌 값을 입력했습니다.: " + number);
    }
  }

  private static String[] inputNames(){
    String[] names = SCANNER.nextLine().split(",");

    for (String name : names) {
      validateNameLength(name);
    }
    return names;
  }

  private static void validateNameLength(String name) {
    if(name.isEmpty()){
      throw new InvalidNameException("이름을 1자 이상 입력해주세요.: ");
    }

    if(name.length() > 5){
      throw new InvalidNameException("이름은 5자를 초과할 수 없습니다.: "+ name);
    }
  }
}
