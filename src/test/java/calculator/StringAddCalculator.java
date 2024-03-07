package calculator;

public class StringAddCalculator {

    String text;
    private static String division = ",:";



    static int splitAndSum(String text) {
        if (isEmpty(text))
            return 0;
        CustomDivisionCheck(text);

        return 0;
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static void CustomDivisionCheck(String text) {
        if (text.contains("//") && text.contains("\n")) {
            int start = text.indexOf("//");
            int end = text.indexOf("\n");
            division = text.substring(start + 1, end);
        }
    }

    private int StringDivision(String text) {
        String[] numbers = text.split(division);
    }

    /* 의문사항 메서드 안에서 다른 메서드를 호출하는것이 좋은가?

    ex) 문자열 -> 문자열 배열로 만든후 정수형 배열로 만든후 합을 구하는 작업을
    splitAndSum 메인 메서드안에서 차례대로 하나씩 하는것이 좋은지

    문자열을 정수형 배열로 변환후 합까지 구하는 메서드를(중간 과정의 구하는 메서드?)
    ex) StringChangeIntAndToTalSum -> 이런 느낌의 메서드 안에서 과정을 전부 처리후 결과반환

    -> 너무 [메서드 안의 메서드] -> [메서드 안의 메서드] 와 같이 타고가지는 않는지 걱정이 됨

    */
}
