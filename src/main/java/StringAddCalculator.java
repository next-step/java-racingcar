import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

    private static final List<String> DEFAULT_DELIMITERS = List.of(",", ":");
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    // 외부에서 호출하는 메소드
    public int splitAndSum(String input) {
        if (input == null || input.isEmpty()) return 0;
        return calculate(input);
    }

    // 계산 로직 수행
    private int calculate(String input) {
        String cleanedInput = removeCustomDelimiterSyntax(input);
        List<String> delimiters = getDelimiters(input);
        List<Integer> numbers = parseToIntList(splitByDelimiters(cleanedInput, delimiters));
        return sum(numbers);
    }

    // 입력된 문자열에서 커스텀 구분자 부분을 제거
    private String removeCustomDelimiterSyntax(String input) {
        return CUSTOM_DELIMITER_PATTERN.matcher(input).replaceFirst("$2");
    }

    // 기본 구분자와 커스텀 구분자를 포함한 구분자의 리스트를 반환
    private List<String> getDelimiters(String input) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (!m.find()) {
            return DEFAULT_DELIMITERS;
        }

        String customDelimiter = m.group(1);
        return new ArrayList<>(DEFAULT_DELIMITERS) {{
            add(customDelimiter);
        }};
    }

    // 문자열을 구분자를 기준으로 분리
    private String[] splitByDelimiters(String input, List<String> delimiters) {
        String regex = String.join("|", delimiters);
        return input.split(regex);
    }

    // 문자열 배열을 양의 정수 리스트로 변환
    private List<Integer> parseToIntList(String[] input) {
        return Arrays.stream(input)
                .map(Integer::parseInt)
                .peek(this::validatePositiveNumber)
                .collect(Collectors.toList());
    }

    // 음의 정수가 포함되어 있으면 RuntimeException을 던짐
    private void validatePositiveNumber(int num) {
        if (num < 0) throw new RuntimeException("음의 정수는 요구 사항에 없습니다.");
    }

    // 정수 리스트의 총합을 리턴
    private int sum(List<Integer> nums) {
        return nums.stream().reduce(0, Integer::sum);
    }
}
