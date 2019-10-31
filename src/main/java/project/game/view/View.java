package project.game.view;

import java.util.List;

public interface View {
    void drawNewLine();
    void drawText(String text);
    void drawCharSequence(int position, char character);
    String readInput();
    int readInputToInt();
}
