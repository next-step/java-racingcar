import step1.Calculator;

public class Application {
    public static void main(String[] args){
        String input = "2 + 3 * 4 / 2";
        System.out.println(Calculator.run(input));
    }
}
