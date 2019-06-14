package calculate;

public class CalculateRunner {
    public static void main(String[] args) {
        String method = "2 + 3 * 4 + 6";
        System.out.println(method + " = " + new Calculator().calculate(method));
    }
}
