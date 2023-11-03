package study;

public class StringAddCalculator {

    public static int add(String s) {

        int sum = 0;

        if(s == null || s.equals("")){
            return 0;
        }

        String[] numbers = s.split(",");
        for(int i = 0; i < numbers.length; i++) {
          sum += Integer.parseInt(numbers[i]);
        }
        return sum;
    }
}
