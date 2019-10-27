package game;

import java.util.List;

public class RacingGameViewImpl implements RacingGameView {

    private static final String NEW_LINE_TEXT = "\n";
    private static final char CAR_POSITION_TEXT = '-';

    @Override
    public void onCarPositionsChange(List<Integer> carPositions) {
        drawNewLine();

        for (Integer each : carPositions) {
            drawCarPosition(each);
        }
    }

    private void drawNewLine() {
        draw(NEW_LINE_TEXT);
    }

    private void drawCarPosition(int position) {
        StringBuilder positionTextBuilder = new StringBuilder();

        for (int i = 0; i < position; i++) {
            positionTextBuilder.append(CAR_POSITION_TEXT);
        }

        draw(positionTextBuilder.toString());
    }

    private void draw(String string) {
        System.out.println(string);
    }
}
