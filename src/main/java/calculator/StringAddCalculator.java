package calculator;

public class StringAddCalculator {

    private static final int ZERO = 0;
    private static final String DELIMETERS=",|:";


    public int splitAndSum(String inputString) {
        if(inputString == null || inputString.isBlank()) {
            return ZERO;
        }
        String[] split = inputString.split(DELIMETERS);
        int[] ints = new int[split.length];

        for(int i=0 ; i<split.length ; i++ ) {
            int i1 = Integer.parseInt(split[i]);
            if(i1 < 0) {
                throw new RuntimeException();
            }
            ints[i] = i1;
        }
        int sum = 0;
        for(int temp : ints) {
            sum += temp;
        }
        return sum;
    }


}
