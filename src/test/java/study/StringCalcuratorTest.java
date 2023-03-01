package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class StringCalcuratorTest {
    List<String> input;
    List<String> numbers;
    List<String> signs;

    List<String> getNumbers(String input) {
     
        return new ArrayList<String>();
    }

    List<String> getSigns(String input) {
     
        return new ArrayList<String>();
    }

    @Test
    void test(){
       String strInput = "2 + 3 * 4 / 2";
       
       input = Arrays.asList(strInput.split(" "));
       
        
    }
    
}
