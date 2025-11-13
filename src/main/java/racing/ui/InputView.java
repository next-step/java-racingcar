package racing.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import racing.domain.CarName;

public class InputView {

  private static final Scanner scanner = new Scanner(System.in);

  private InputView() {
  }

  public static int inputTryCnt(Message message) {
    System.out.println(message.getMessage());
    while (true) {
      try {
        return scanner.nextInt();
      } catch (Exception e) {
        System.out.println("올바른 숫자를 입력해주세요:");
        scanner.nextLine();
      }
    }
  }

  public static List<CarName> inputCarName(Message message) {
    List<CarName> names = new ArrayList<>();
    System.out.println(message.getMessage());
    String line = scanner.next();
    String[] tokens = line.split(",");
    for (String name : tokens) {
      names.add(new CarName(name));
    }
    return names;
  }

  public static void close() {
    scanner.close();
  }
}