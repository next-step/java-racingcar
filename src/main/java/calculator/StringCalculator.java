package calculator;

public class StringCalculator {

    public static int[] ZERO = {0};
    public static int[] splitAndSum(String text){

        if (isBlank(text)) {  // " 객체지향: 객체에게 메시지를 보내는 형태로 개선하자 " -> text.isBlank()
            // text == null || text.isBlank() -> 메서드로 빼면 추상화 레벨1 증가
            return ZERO;
        }

        return toPositives(split(text));
        // 메서드 1가지 일 하도록 리팩토링 하자. 성능 문제 생길 경우 거~~의 없다.
        // for 문 한 번 더돈다고 큰 일 안난다. 가독성이 더 중요.
        // DB 쿼리, 외부 API 연동 시 성능 문제 날 가능성이 더 크니까 그 쪽은 성능 신경 써야 한다.
    }

    private static String[] split(String text) {
        return text.split(",");
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

//    private static int sum(String[] values) {
//        int sum = ZERO;
//
//        for (String value : values) { // => 반복문 파싱 2가지 작업을 하고 있다
//            // -> 메서드가 한 가지 일만 하도록 하자 -> 자연스레 private method 많아진다
//            sum += Integer.parseInt(value);
//        }
//        return sum;
//    }

    // text.equals("") -> text.isBlank() 이런 식으로 개선하자
    // else 를 쓰지말자 -> 조기 리턴
    // 인덴트를 줄이자 -> 메서드를 분리하면 됨
    // for 문 안에 if 문이 있따면, java8 stream 활용하기

    private static int[] toPositives(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            int number = toPositive(values[i]);
            numbers[i] = number;
        }
        return numbers;
    }

    private static int toPositive(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다");
        }
        return number;
    }

}
