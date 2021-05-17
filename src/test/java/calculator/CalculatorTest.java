package calculator;

public class CalculatorTest {

//    @Test
//    @BeforeEach
//    void test() {
//        Calculator cal = new Calculator();
//        String sentence = "2 + 3 * 4 / 2";
//        final String[] arr = sentence.split(" ");
//        for (int i = 0; i < arr.length; i++) {
//            if (!cal.isStringDouble(arr[i].toString())) {
//                int num1 = Integer.valueOf(arr[i - 1]);
//                int num2 = Integer.valueOf(arr[i + 1]);
//            }
//        }
//    }
//
//    @DisplayName("사칙연산의 종류를 파악하는 함수")
//    @ParameterizedTest
//    @CsvSource(value = {"+:1:2:3", "-:3:4:-1", "*:4:30:120", "/:5:40:"}, delimiter = ':')
//    void test(String input, int num1, int num2, int result) {
//        Calculator cal = new Calculator();
//        int idx = cal.calculatorInput(input);
//        String plus = cal.plus(idx, num1, num2);
//        String minus = cal.minus(idx, num1, num2);
//        String multiply = cal.multiply(idx, num1, num2);
//        String divide = cal.divide(idx, num1, num2);
//        assertThat(cal.plus(idx, num1, num2)).isEqualTo(result);
//    }

}
