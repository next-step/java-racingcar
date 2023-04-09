/*
package calculator;
*/
/**
 * calculator 패키지 안 파일들은 줌 강의를 보고 학습용으로 작성한 내용입니다.
 *//*

public class StringCalculator {

    public static final int ZERO = 0;
    public static final String DELIMITER = ",|:";

    public static int splitAndSum(String text) {

        // 객체지향에서는 test.equals("")로 짜면 안좋다.
        */
/**
         * 메시지를 보내야 한다. text에게 메세지를 보내라. isBlank() 같이.
         *
         * elses 키워드를 사용하지 않으려면 early return을 사용하면 된다.
         * -> else문 없이 프로그래밍 가능
         *
         * indent 줄이는 가장 좋은 방법은 method 분리
         *
         * 추상화 레벨이 똑같으면 코드의 가독성이 좋아진다.
         *
         * oop 연습 하기 전까지는 stream 사용하는것 지양하기.
         * 객체지향 설계 연습 잘 안되어있으면 stream 사용하지 않으면서 미션 진행해보기.
         * lotto 미션 정도까지는 stream 없이 구현해보기
         *
         * application logic 구현시 collection에 들어가는건
         * 많아봤자 1000개도 안된다.
         * for문 한번 더 돌아봤자 0.00x ms 성능 떨어진다. (성능 거의 영향 미치지 않는다.)
         * computing power가 떨어지던 예전에는 중요했지만, 현재는 인건비가 가장 비싸다.
         * 성능이 떨어지면 그때가서 고치면 된다.
         * 지금은 메서드가 한가지 일만 하도록 해서 가독성/ 유지보수성에 집중해라.
         * 문제가 되는 경우는 1%도 안된다.
         * db 쿼리 날리거나, 외부 api 연동하는 경우 등에서만 성능이 중요함.
         * application logic에서는 성능은 후순위로 밀어도 된다.
         * 훨씬 성능 높힐 수 있는 다른 영역이 많기 때문에..
         *
         * public인 경우 다 추상화시켜 쪼개는거 찬성이지만
         * private인 경우, 쪼개는건 너무 과한거 아닌가.. 라는게 포비 생각
         * 따라서 private 메서드의 number < 0 경우 메서드로 안뺀다.
         *
         * tdd사이클, 리펙토링 경험하는것이 더 중요하다.
         * tdd 하기 쉬웠던 이유 : 메서드가 하나고, input과 output이 명확함.
         * 어디를 테스트 코드로 만들어야 할지도 막막할 것이다.
         * 어디서 부터 tdd로 해야할지도 막막할 것이다.
         *
         * 현재는 기능목록 연습, 리펙토링, 메서드 분리 연습..
         * 모든 부분을 tdd를 못할것 같으면, 할 수 있는 부분만 하면 된다.
         * 할 수 있는 부분에 대해서만 단위테스트를 만들고.. tdd를 안해도 된다.
         * 할 수 있는 부분만 tdd를 하면 된다.
         *
         * oop 또한 감이 왔다가도 다른 요구사항 받으면 막막해진다.
         *
         * 리뷰어와 다른 의견이면 반론을 제기하라.
         * e.g) stream을 안쓰는게 좋다 -> oop 연습을 하기 위해서. 근거를 찾으면 리뷰어에게 말해라.
         * 
         * 클래스 분리는 문자열, 등을 포장해라 (생활원칙 참고)
         * 클래스 분리는 메서드 분리에 비해 훨씬 어렵다.
         *
         *//*

        if (isBlank(text)) {
            return ZERO;
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
        */
/**
         * 추상화 한단계 한것. (구현 숨긴것)
         *//*

        int sum = ZERO;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            int number = toInt(values[i]);
            numbers[i] = number;
        }
        return numbers;
    }

    private static int toInt(String values) {
        int number = Integer.parseInt(values);
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }
}
*/
