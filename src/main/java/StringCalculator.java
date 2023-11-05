public class StringCalculator {

    private static final String DEFAULT_DELIMETER = ",:";
    private static final String CUSTOME_DELIMETER_START_POINT = "//";
    private static final String CUSTOME_DELIMETER_END_POINT = "\n";
    public static int cal(String o) {
        if (o == null || o.isBlank()) {
            return 0;
        }

        String finalDelimeter = DEFAULT_DELIMETER;

        if (o.contains(CUSTOME_DELIMETER_END_POINT)) {
            int customDelimeterEndPointIndex = o.indexOf(CUSTOME_DELIMETER_END_POINT);
            char c = o.charAt(customDelimeterEndPointIndex - 1);

            o = o.substring(customDelimeterEndPointIndex + 1);

            finalDelimeter = DEFAULT_DELIMETER + c;
        }


        String[] split = o.split("["+ finalDelimeter +"]");
        int sum = 0;
        for (String a : split) {
            int i = Integer.valueOf(a);
            if (i < 0) {
                throw new RuntimeException();
            }
            sum += i;
        }
        return sum;
    }
}
