package racing.domain;

public class ConvertOutputView {

    private final static StringBuilder stringBuilder = new StringBuilder();

    private ConvertOutputView() {
    }

    public static String convertOutputView(Position position) {
        stringBuilder.setLength(0);
        stringBuilder.append("-");
        for (int i = 0; i < position.getPosition(); i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
