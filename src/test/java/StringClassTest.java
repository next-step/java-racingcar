import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StringClassTest {

    static String numberData;
    static String [] array;

    @BeforeAll
    public static void init() {
        numberData = "1,2";
    }
    /**
     * 요구사항 : 1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인
     * 1. 문자열을 나누어서 배열에 저장한다.
     * 2. 배열에 1과 2가 각각 조회되는지 or contains로 두개가 다 존재하는지
     * 검증하기.
     *
     */
    @Test
    public void SplitTest() {
        array = numberData.split(",");
        Arrays.stream(array).peek(i -> System.out.println(i));

    }
}
