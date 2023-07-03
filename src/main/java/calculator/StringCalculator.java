package calculator;

public class StringCalculator {

    public static int sum(String number) {
        String[] splitNumbers = number.split(",");
        int answer = 0;
        for (String splitNumber : splitNumbers) {
            answer += Integer.parseInt(splitNumber);
        }
        return answer;
    }
}
