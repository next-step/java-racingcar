package step2;

import java.util.Arrays;

public class StringAddCalculator {

    private static String createRegex(String separators) {
        return "["+separators+"]";
    }

    public int calculate(String input) {
        if(checkIfEmptyInput(input)) {
            return 0;
        }
        if(!checkIfValidPattern(input)) {
            throw new IllegalArgumentException("Invalid Pattern are not allowed");
        }
        if(!checkIfOnlyPositiveNumbers(input)) {
            throw new IllegalArgumentException("Negative numbers or NaN are not allowed");
        }

        String numbersWithSeparators = extractNumbers(input); // "\\;\n1;2;3" -> "1;2;3"
        String separators = filterSeparators(input); // SEPARATORS = ",:" -> ",:;"
        int[] numbers = splitNumbers(numbersWithSeparators, separators); // e,g. "1,2;3" -> [1,2,3]
        int result = addNumbersInArray(numbers); // [1,2,3] -> 6

        return result;
    };

    public int[] splitNumbers(String numbers, String separators) {
        String regex = createRegex(separators);

        // [TODO] 강의에서 로또 미션 전까지는 stream 사용 없이 해보라는 조언
        return Arrays.stream(numbers.split(regex))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public int addNumbersInArray(int[] numbers) {
        int sum = 0;

        if (numbers == null) {
            return sum;
        }

        for (int num:numbers) {
            sum += num;
        }

        return sum;
    }

    public String[] checkIfOnlyNumbers(String numbersWithCustomSeparator) {
        String[] arr = numbersWithCustomSeparator.split("\n");
        return arr;
    }

    public String filterSeparators(String numbersWithCustomSeparator) {
        String separators = ",:"; // default_separators

        String[] arr = checkIfOnlyNumbers(numbersWithCustomSeparator);

        if (arr.length > 1) {
            separators += arr[0].substring(2);
        }

        return separators;
    }

    public String extractNumbers (String numbersWithCustomSeparator) {
        String[] arr = checkIfOnlyNumbers(numbersWithCustomSeparator);
        return arr[arr.length-1];
    }

    public boolean checkIfValidPattern(String input) {
        // 커스텀 구분자 형식이 유효하지 않으면 오류
        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            if (parts.length < 2 || parts[0].length() < 3 || !parts[0].substring(2).matches("^[^\\d]+$")) {
                return false; // 커스텀 구분자가 숫자나 빈 문자열이면 오류
            }
        } else if (!Character.isDigit(input.charAt(0)) && !input.startsWith("//")) {
            return false; // "\n;\n1;2;3;" 과 같은 경우
        }

        return true; // 모든 검증을 통과하면 유효
    }

    public boolean checkIfOnlyPositiveNumbers(String input) {
        // 숫자 확인: 입력 문자열에서 유효한 숫자 배열로 변환 시도
        try {
            String separators = filterSeparators(input);
            String numbers = extractNumbers(input);
            String[] tokens = numbers.split(createRegex(separators));

            for (String token : tokens) {
                int number = Integer.parseInt(token.trim());
                if (number < 0) { // 음수일 경우 오류
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            return false; // 숫자가 아닌 값이 포함되어 있으면 오류
        }
        return true;
    }

    public boolean checkIfEmptyInput (String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }
        return false;
    }

}
