package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

public class calculate {

    @Test
    @CsvSource(value = {"1+14+8: 23", "2+4:6"}, delimiter = ':')
    void add(String cal, double result) {
        boolean checkBoolean = true;
        String[] split;
        int split_num1, split_num2;
        int i=0;
        while (checkBoolean) {
            if (cal.indexOf("+") >1) {
                checkBoolean =false;
            }else {
                split =cal.split("//+");
//                split_num1 = (double)split[0];
                split =cal.split("//+");
//                split[0]
            }

        }


    }
}
