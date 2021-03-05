public class Main {


  public static void main(String[] args) {
      Calculator calculator = new Calculator();
      calculator.enterFormula("1 / 0");
      calculator.calculate();
  }
}
