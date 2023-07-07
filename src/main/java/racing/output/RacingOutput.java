package racing.output;

public class RacingOutput {

    private RacingOutput() {
    }

    public static RacingOutput getInstance() {
        return RacingOutputLazyHolder.INSTANCE;
    }

    private static class RacingOutputLazyHolder {
        private static final RacingOutput INSTANCE = new RacingOutput();
    }

    public void print(String output) {
        System.out.println(output);
    }
}
