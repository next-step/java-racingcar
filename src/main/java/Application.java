import calculatorFunction.Calculator;
import calculatorFunction.GetInput;

public class Application {
    public static void main(String[] args) {
        System.out.println("문자열 계산기를 사용하시려면 1, 자동차 경주를 사용하시려면 2를 눌러주세요.");
        int flag=1;
        if(flag==1) {
            System.out.println("수식을 입력하시오: ");
            String str = GetInput.inputString();
            str = str.replace(" ", "");
            String[] stringArray = GetInput.parsing(str);
            Calculator calculator = new Calculator();
            calculator.calculate(stringArray);
        }
        if(flag==2){

        }
    }
}
