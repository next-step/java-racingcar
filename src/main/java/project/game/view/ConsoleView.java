package project.game.view;

import project.InputTool;

public class ConsoleView implements View {

    private InputTool mInputTool;

    public ConsoleView() {
        mInputTool = new InputTool();
    }

    @Override
    public void drawNewLine() {
        drawText(System.lineSeparator());
    }

    @Override
    public void drawText(String string) {
        System.out.println(string);
    }

    @Override
    public String readInput() {
        return mInputTool.readLine();
    }
}
