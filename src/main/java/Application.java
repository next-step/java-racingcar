import step1.Calculator;

public class Application {
    public static void main(String[] args){
        String input = "2 + 3 * 4 / 2";
        int result = new Calculator().run(input);
        System.out.println(result);
    }
}
