package calculator;

import java.util.Arrays;
import java.util.List;

/**
 * String Calculator 에서 사용 가능한 기호들을 이곳에서 관리합니다.
 */
public interface Symbols {

    String PLUS_SYMBOL = "+";
    String MINUS_SYMBOL = "-";
    String MULTIPLY_SYMBOL = "*";
    String DIVID_SYMBOL = "/";

    List<String> ENABLED_ARITHMETIC_SYMBOLS = Arrays.asList(PLUS_SYMBOL, MINUS_SYMBOL, MULTIPLY_SYMBOL, DIVID_SYMBOL); // Arithmetic symbols

}
