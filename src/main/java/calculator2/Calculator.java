package calculator2;

public class Calculator {
    public static String[] tokenNum (String num) {
        if (num == null || num.isBlank()) return new String[]{"0"};
        String [] splitNum = num.split(",|:");
        return splitNum;
    }
    public static int sum (String num) {
        int result = 0;
        String[] splitNum = tokenNum(num);
        for (int i = 0 ; i< splitNum.length ; i++) {
            result += Integer.parseInt(splitNum[i]);
        }
        return result;
    }
}
