package racingcar;

public class InputView {
    private final Screen screen = new Screen();
    private final Console console = new Console();

    public String[] participantApplication() {
        screen.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return splitName(console.inputString());
    }

    public int playCount() {
        screen.print("시도할 회수는 몇 회 인가요?");
        return console.inputInt();
    }

    private String[] splitName(String name) {
        return name.split(",");
    }

}
