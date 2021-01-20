package caculator;

public class CalculatorApplication {

    public static void main(String[] args) {
        Input input = new Input();
        String inputValue = input.input("문자열을 입력하세요: ");
        StringCalculator stringCalculator = new StringCalculator();
        double calculate = stringCalculator.calculate(inputValue);
        System.out.println("계산 결과: " + calculate);
    }
}
