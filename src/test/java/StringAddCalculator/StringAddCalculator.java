package StringAddCalculator;

public class StringAddCalculator {
    public static int splitAndSum(String inText) {

        if(inText == null || inText.isEmpty())
            return 0;

        String inTextCheckedSeparator = checkSeparator(inText);

        String [] splitInText = inTextCheckedSeparator.split("[: , ;]+");

        int splitAndSumResult = 0;

        for(String stringNum : splitInText){

            int integerNum = convertInteger(stringNum);

            splitAndSumResult += integerNum;

        }

        return splitAndSumResult;

    }

    private static int convertInteger(String stringNum) {
        int integerNum = Integer.parseInt(stringNum);

        if(integerNum<0)
            throw new RuntimeException("음수가 입력되었습니다.");

        return integerNum;
    }

    private static String checkSeparator(String inText) {
        if(inText.substring(0,2).equals("//") && inText.substring(3,4).equals("\n"))
            return inText.substring(4, inText.length());

        return inText;
    }
}
