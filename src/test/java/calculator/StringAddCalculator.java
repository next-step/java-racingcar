package calculator;

public class StringAddCalculator {
    private static String division = "[,:]";

    static int splitAndSum(String text) {
        if (isEmpty(text))
            return 0;
        text = CustomDivisionCheck(text);

        // System.out.println(text);
        // 테스트를 통해서는 결과를 틀렸다는것과 에러메시지만 보여서 그런지 자꾸 System.out.을 통해서 값을 찍어보는데 괜찮을까요?
        return StringDivision(text);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String CustomDivisionCheck(String text) {
        if (text.contains("//") && text.contains("\n")) {
            int start = text.indexOf("//");
            int end = text.indexOf("\n");
            division = text.substring(start + 2, end);
            return text.substring(end + 1);
        }
        return text;
    }

    private static int StringDivision(String text) {
        String[] texts = text.split(division);
        return StringToInt(texts);
    }

    private static int StringToInt(String[] texts) {
        int sum = 0;
        for (String text : texts) {
            int num = Integer.parseInt(text);
            NumberMinusCheck(num);
            sum += num;
        }
        return sum;
    }

    private static void NumberMinusCheck(int num) {
        if (num < 0)
            throw new RuntimeException("음수입니다");
    }

    /* 의문사항 메서드 안에서 다른 메서드를 호출하는것이 좋은가?

    ex) 문자열 -> 문자열 배열로 만든후 정수형 배열로 만든후 합을 구하는 작업을
    splitAndSum 메인 메서드안에서 차례대로 하나씩 하는것이 좋은지

    문자열을 정수형 배열로 변환후 합까지 구하는 메서드를(중간 과정의 구하는 메서드?)
    ex) StringChangeIntAndToTalSum -> 이런 느낌의 메서드 안에서 과정을 전부 처리후 결과반환

    -> 너무 [메서드 안의 메서드] -> [메서드 안의 메서드] 와 같이 타고가지는 않는지 걱정이 됨

    */
}
