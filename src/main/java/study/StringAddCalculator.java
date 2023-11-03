package study;

public class StringAddCalculator {

    private static final int NULL_EMPTY_NUM = 0;
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()){
            return NULL_EMPTY_NUM;
        }

        String[] stringList = text.split("[^0-9]");

        return sum(stringList);
    }

    private static int sum(String[] stringList) {
        int result = 0;

        for (String s : stringList) {

            if (s.isEmpty()){
                continue;
            }

            int num = Integer.parseInt(s);
            negativeException(num);

            result += num;
        }

        return result;
    }


    private static void negativeException(int num){
        if (num < 0){
            throw new RuntimeException();
        }
    }

}
