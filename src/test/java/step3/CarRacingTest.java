package step3;

import org.junit.jupiter.api.Test;

class CarRacingTest {
//  public void processUserInput() {
//    processUserInput(new Scanner(System.in), System.out);
//  }
//
//  /** For testing. Package-private if possible. */
//  public void processUserInput(Scanner scanner, PrintWriter output) {
//    output.println("Give a number between 1 and 10");
//    int input = scanner.nextInt();
//
//    while (input < 1 || input > 10) {
//      output.println("Wrong number, try again.");
//      input = scanner.nextInt();
//    }
//
//    return input;
//  }

  @Test
  public void test_input(){
//    CarRacing carRacing = new CarRacing();
//    carRacing.gameStart();

//    System.out.println("자동차 대수는 몇 대 인가요?");
//    Scanner scanner = new Scanner(System.in);
//    String value = scanner.nextLine();

    RacingMain.getCarCount();
    RacingMain.getTryCount();
  }

}