package step2;

import java.util.regex.Pattern;

public class StringAddCalculator_poby {

    public static final int ZERO = 0;
    public static final String DELIMITER = ",|:";

    //메소드가 한가지 역할만 하게 만들어야 재사용성이 높아짐
    //인덴트를 줄이는 가장좋은 방법은 메소드로 따로 빼는거
    public static int splitAddSum(String text) {
        //로컬변수를 끌고가는건 좋지 않음 > 이 코드르 읽는 개발자가 로컬변수를 따라가야 하기 때문
        int sum = ZERO;
        if (isBlank(text)) {
            return ZERO;        //변수를 계속 끌고가지 않게 얼리리턴!
        }
        return sum(toInts(split(text)));
    }

    private static String[] split(String text) {
        return text.split(DELIMITER);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(int[] numbers) {
        int sum = ZERO;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for(int i = 0; i< values.length; i++){
            int number = toInt(values[i]);
            numbers[i] = number;
        }
        return numbers;
    }

    //public 메소드에서는 전체 로직파악하는게 중요해서 세세하게 메소드를 나눴지만(= 한가지 역할만 할 수 있도록) (ex. 형변환, 널,빈칸 조건)
    //private 메소드 속에서 같은 경우에 위에 예시를 똑같이 메소드로 빼는건 과하다!
    private static int toInt(String value) {
        int number = Integer.parseInt(value);
        if(number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }
}