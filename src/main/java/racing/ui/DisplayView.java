package racing.ui;

public class DisplayView implements View {

    public final String RACE_START_MESSAGE = "실행 결과";

    @Override
    public void display(String content) {
        System.out.println(content);
    }

    public void displayEmptyLine() {
        this.display("");
    }

    public void displayRaceStart() {
        this.display(RACE_START_MESSAGE);
    }
}
