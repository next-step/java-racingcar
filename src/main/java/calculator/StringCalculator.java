package calculator;

import jdk.internal.joptsimple.internal.Strings;

public class StringCalculator {

    private void checkNullOrEmpty(String str) throws IllegalArgumentException {
       if(Strings.isNullOrEmpty(str)) {
           throw new IllegalArgumentException("Argument is null or empty.");
       }
    }

}
