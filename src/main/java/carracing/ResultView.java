package carracing;

public class ResultView implements StepPrint {
    private static final StringBuilder builder = new StringBuilder();

    private static String stepLine(int step) {
        builder.delete(0, builder.length());
        for (int i = 0; i < step; i++) {
            builder.append("-");
        }
        return builder.toString();
    }

    @Override
    public void print(int step) {
        System.out.println(stepLine(step));
    }

    @Override
    public void delimiter() {
        System.out.println();
    }
}
