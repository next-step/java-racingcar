package racinggame.ui;

public class RacingMessageWriter implements MessageWriter {
    @Override
    public void write(final String message) {
        System.out.println(message);
    }
}
