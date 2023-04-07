package calculator;

public class StringAddCalculator {

    private static final int ZERO = 0;
    private static final String DELIMETERS=",|:";


    public int splitAndSum(String inputString) {
        String[] split = inputString.split(DELIMETERS);
        int[] ints = new int[split.length];

        for(int i=0 ; i<split.length ; i++ ) {
            ints[i] = Integer.parseInt(split[i]);
        }
        int sum = 0;
        for(int temp : ints) {
            sum += temp;
        }
        return sum;
    }


}
