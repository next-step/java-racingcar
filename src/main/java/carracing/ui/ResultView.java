package carracing.ui;

public class ResultView {

    private ResultView() {
    }

    public static String createNameAndPositionView(String name, int position) {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" : ");
        sb.append(("-".repeat(position)));

        return sb.toString();
    }
}
