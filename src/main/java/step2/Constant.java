package step2;

import java.util.regex.Pattern;

/**
 * 패키지 접근 제어자를 위해 모든 상수는 protected로 설정
 */
public class Constant {
    protected static final Pattern prefixDynamicSeparatorRegEx = Pattern.compile("^//(.)\n");

    protected static final Pattern dynamicSeparatorRegEx = Pattern.compile(prefixDynamicSeparatorRegEx.pattern() + "(.*)$");

    protected static final String defaultSeparator = "[,:]";

    private Constant() {
    }
}
