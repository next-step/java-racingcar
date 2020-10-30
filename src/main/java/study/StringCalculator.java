package study;

public class StringCalculator {

    public int plus(int first, int second) {
        return first+second;
    }

    public int minus(int first, int second) {
        return first-second;
    }

    public int multiply(int first, int second) {
        return first*second;
    }

    public int divide(int first, int second) throws Exception{
        if( first % second != 0 ) throw new Exception("나눗셈의 경우. 결과 값이 정수로 떨어지는 경우로 한정됩니다.");

        return first / second ;
    }

    public int calculate(String input) {
        if(isBlank(input)) throw new IllegalArgumentException();

        String[] arr = splitByWhiteSpace(input);

        for(int i = 1; i < arr.length - 2; i+=2) {
            int first = Integer.parseInt(arr[i-1]);
            int second = Integer.parseInt(arr[i+1]);
        }


        return 0;
    }

    boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    String[] splitByWhiteSpace(String input) {
        return input.split(" ");
    }

}
