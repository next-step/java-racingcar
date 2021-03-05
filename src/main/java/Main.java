public class Main {


  public static void main(String[] args) {
      Calculator calculator = new Calculator();
      calculator.enterFormula("2 * 3 + 5");
      System.out.println(calculator.calculate());
  }
}
