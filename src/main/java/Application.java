import calculatorFunction.Calculator;
import calculatorFunction.GetInput;

public class Application {
    public static void main(String[] args) {
        System.out.println("수식을 입력하시오: ");
        String str = GetInput.inputString();
        str = str.replace(" ", "");
        String[] stringArray = GetInput.parsing(str);
        Calculator calculator = new Calculator();
        int answer = calculator.calculate(stringArray);
        System.out.println("정답: "+answer);
    }
}
