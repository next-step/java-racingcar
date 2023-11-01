package calculator;

public class Util {

    public static int strToInt(String str){
        try{
            return Integer.parseInt(str);
        }catch (NumberFormatException ex){
            throw new NotNumberException();
        }
    }

}
