package racingcar;

public class Printer {

    public void printInputCarNameMessage(){
        String NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
        System.out.println(NAME_MESSAGE);
    }

    public void printInputTurnMessage(){
        String TURN_MESSAGE = "시도할 횟수는 몇 번인가요?";
        System.out.println(TURN_MESSAGE);
    }
    public void printErrorMessage(String message) {
        String ERROR_PREFIX = "[ERROR] ";
        System.out.println(ERROR_PREFIX + message);
    }
}
