package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Strings {
    // + - / *

    public static boolean isBlank(String input) {
        if(input == null || input.trim().isEmpty()) throw new IllegalArgumentException("input is null or blank");
        else return true;
    }

    public static boolean checkSymbol(String[] splitBlank){
        String pattern = "[\\d\\+\\-\\*\\/]";
        boolean check = false;
        for(int i=0;i<splitBlank.length;i++){
            check = splitBlank[i].matches(pattern);
            if(!check) throw new IllegalArgumentException("symbol error");
        }
        return check;
    }

    @Test
    public void cutByOperation(String input) {
        input = "2+3*4/2";
        System.out.println(input.indexOf("/"));
    }

}
