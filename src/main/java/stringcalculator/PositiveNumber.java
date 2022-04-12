package stringcalculator;

public class PositiveNumber {


    public static final String PARSING_FAIL_MESSAGE = "String to Integer Parsing Failed";
  
    private PositiveNumber(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        this.number = number;
    }

  
    public static PositiveNumber createPositiveNumber(String string) {
  
        return new PositiveNumber(getInteger(string));
    }

    private static int getInteger(String string) {
        int parsedInt;
        try {
            parsedInt = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new NumberFormatException(PARSING_FAIL_MESSAGE);
        }
        return parsedInt;
      
    }

    int getNumber() {
        return number;
    }
}
