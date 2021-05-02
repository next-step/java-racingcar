package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.Cal;

public class CalTest {
    @DisplayName("전부쪼개기")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2"})
    void caltests(String input){
        System.out.println(input);
        Cal ca = new Cal();


        String [] splitresult = null;
        splitresult = ca.splitWord(input); //쪼갠 데이터 string 에 저장

        String [] sachicresult = null;
        sachicresult = ca.calsachicInput(splitresult); //쪼갠것중에 사칙연산자 저장

        String [] numberresult = null;
        numberresult =  ca.extraction(splitresult); //쪼갠것 중에 숫자

        String result = null;
        result = ca.docal(sachicresult,numberresult);
        System.out.println(result);

    }
}
