package StringAddCalculator;

public class StringAddCalculator {
    public static int splitAndSum(String inText) {

        if(inText == null || inText.isEmpty())
            return 0;


        String inTextExcluSeparator = inText;

        if(inText.substring(0,2).equals("//") && inText.substring(3,4).equals("\n"))
            inTextExcluSeparator = inText.substring(4,inText.length());


        String [] splitInText = inTextExcluSeparator.split("[: , ;]+");

        int splitAndSumResult = 0;

        for(String stringNum : splitInText){

            int integerNum = Integer.parseInt(stringNum);

            splitAndSumResult += integerNum;

        }

        return splitAndSumResult;

    }
}
