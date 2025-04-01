package step3;

public class OutputView {
    public static StringBuilder makeForwardLine(StringBuilder sb) {
        return sb.append("-");
    }

    public static void draw(StringBuilder sb) {
        System.out.println(sb.toString());
    }

    public static void drawLineSeparator() {
        System.out.println();
    }
}
