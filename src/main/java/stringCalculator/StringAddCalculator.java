package stringCalculator;

public class StringAddCalculator {

    public static int splitAndSum(String string){
        NumericString numericString = new NumericString(string);
        if(numericString.nullOrEmpty()){
            return 0;
        }
        return numericString.sum();
    }
}
