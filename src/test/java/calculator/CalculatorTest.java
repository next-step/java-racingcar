package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void isBlank() {
        String str = "2 + 3 * 4 / 2";
        String[] splitBlank = str.split(" ");
        Strings.isBlank(str);
        Strings.checkSymbol(splitBlank);

        int cnt=0;
        for(int i=0;i<splitBlank.length;i++){
            if(splitBlank[i].equals("+") || splitBlank[i].equals("-") || splitBlank[i].equals("*")|| splitBlank[i].equals("/")){
                cnt++;
            }
        }
        String stringJoin = String.join("", splitBlank);
        for(int i=0;i<cnt;i++){
            String[] a = Strings.cutByOperation(stringJoin);

            if(cnt==i+1){
                int result = Operation.result(a[1],Integer.valueOf(a[0]),Integer.valueOf(a[2]));
            }else {
                String[] b = Strings.cutByOperation(a[2]);
                int result = Operation.result(a[1],Integer.valueOf(a[0]),Integer.valueOf(b[0]));
                stringJoin =result+b[1]+b[2];
            }
        }

    }

}