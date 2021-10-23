package racingcar.views;

import java.util.*;

public class InputView {

    public static final String QUESTION_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String QUESTION_ROUND = "시도할 회수는 몇회인가요?";

    private final Map<String, String> answerMap;


    public InputView () {
        answerMap = new HashMap<>();
    }


    public void getRacingInformation() {

        Scanner scanner = new Scanner(System.in);

        runQuestionAndAnswers(QUESTION_NAMES, scanner);
        runQuestionAndAnswers(QUESTION_ROUND, scanner);
    }


    private void runQuestionAndAnswers(String question, Scanner scanner) {
        printQuestion(question);
        String answer = getAnswer(scanner);
        saveAnswers(question, answer);
    }


    private void saveAnswers(String questionKey, String answerValue) {
        answerMap.put(questionKey, answerValue);
    }


    private String getAnswer(Scanner scanner) {
        if (!scanner.hasNext()) {
            System.out.println("입력값이 없습니다. 다시 한 번 입력해주세요!");
        }

        return scanner.nextLine();
    }


    private void printQuestion(String question) {
        System.out.println(question);
    }


    public Map<String, String> getAnswerMap() {
        return answerMap;
    }

}
