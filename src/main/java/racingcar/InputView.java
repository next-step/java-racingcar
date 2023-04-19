package racingcar;

public class InputView {

    private final Screen screen = new Screen();
    private final Console console = new Console();

    public int participantApplication() {
        screen.print("자동차 대수는 몇 대 인가요?");
        return console.inputInt();
    }

    public int playCount() {
        screen.print("시도할 회수는 몇 회 인가요?");
        return console.inputInt();
    }

}
