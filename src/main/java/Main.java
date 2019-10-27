import step1.StringCalculator;

public class Main {

    public static void main(String[] args) {
        String input = "2 + 3 * 4 / 2";
        System.out.println(new StringCalculator(input).execute());
    }
}
