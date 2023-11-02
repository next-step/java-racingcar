package step2;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparatorManager {
    private static final String[] defaultSeparators = {",", ":"};
    private static ArrayList<String> separators = new ArrayList<>();

    public SeparatorManager() {
        for (String separator : defaultSeparators) {
            separators.add(separator);
        }
    }

    /**
     * 커스텀 구분자 형식과 일치하는 구분자를 찾아서 separators 리스트에 추가
     *
     * @param str
     * @return 커스텀 구분자 패턴을 제외한 문자열
     * 커스텀 구분자 패턴과 일치하는 형식이 없는 경우 문자열 그대로 반환
     */
    public String findCustomSeparator(String str) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
        if (m.find()) {
            separators.add(m.group(1));
            return m.group(2);
        }

        return str;
    }

    public String getRegex() {
        return String.join("|", separators);
    }
}
