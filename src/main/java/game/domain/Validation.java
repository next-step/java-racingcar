package game.domain;

public class Validation {

    public static void checkIfPositiveNumber(String value){
        try {
            int i = Integer.parseInt(value);
            if(i <= 0) throw new NumberFormatException();
        }catch (NumberFormatException e){
            throw new RuntimeException();
        }
    }
}
