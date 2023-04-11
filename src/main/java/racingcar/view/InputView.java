package racingcar.view;

import java.util.*;

public class InputView {
    // 사용자에게 입력값을 받기위한 질문 선언
    private static final List<String> QUESTIONS = new ArrayList<>(Arrays.asList("자동차 대수는 몇 대 인가요?", "시도할 회수는 몇 회 인가요?"));
    private static final Iterator<String> QUESTIONS_ITERATOR = QUESTIONS.iterator();
    private final Scanner scanner = new Scanner(System.in); // System.in 은 사용자로부터 입력을 받기 위한 입력 스트림이다.

    public List<Integer> input() {
        // 자동차 수와 시도할 회수 정보를 담음 list
        List<Integer> inputValues = new ArrayList<>();

        while (QUESTIONS_ITERATOR.hasNext()) {
            System.out.println(QUESTIONS_ITERATOR.next());
            inputValues.add(scanner.nextInt());
        }

        return inputValues;
    }
}
