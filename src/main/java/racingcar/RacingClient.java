package racingcar;

public class RacingClient {
    public static void main(String[] args) {
        Racing racing = new Racing("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).", "시도할 회수는 몇회인가요?");
        racing.start();
    }
}
