package step4.carracing.util;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
  private final Scanner scanner;

  public InputView(Scanner scanner) {
    this.scanner = scanner;
  }

  public List<String> receiveCarNames() {
    System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    String input = scanner.nextLine();
    return Arrays.stream(input.split(","))
        .map(String::trim)
        .collect(Collectors.toList());
  }

  public int receiveTryCount() {
    System.out.println("시도할 회수는 몇 회 인가요?");
    return scanner.nextInt();
  }
}
