package racing.util;

import racing.model.Position;

public class ConvertOutputView {

    private ConvertOutputView() {

    }
    public static String convertOutputView(Position position) {
        StringBuilder convertResult = new StringBuilder();
        convertResult.append("-");
        for (int i = 0; i < position.getPosition(); i++) {
            convertResult.append("-");
        }
        return convertResult.toString();
    }
}
