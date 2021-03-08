package step_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameInputView {
    private final List<String> promptMessages;
    private final Scanner inputScanner;

    private GameInputView(List<String> messages) {
        this.inputScanner  = new Scanner(System.in);
        this.promptMessages = messages;
    }

    public GameInputResult initialized() {
        GameInputResult.Builder gameInputResultBuilder = new GameInputResult.Builder();
        promptMessages.forEach(message -> {
            System.out.println(message);
            gameInputResultBuilder.enterValue(inputScanner.nextInt());
        });
        return gameInputResultBuilder.build();
    }

    public static class Builder {
        private final List<String> promptMessages = new ArrayList<>();
        public Builder enterCarsMessage(String message) {
            this.insertMessage(message);
            return this;
        }

        public Builder executionCountMessage(String message) {
            this.appendMessage(message);
            return this;
        }

        private void appendMessage(String message) {
            this.promptMessages.add(message);
        }
        private void insertMessage(String message) {
            this.promptMessages.add(0, message);
        }

        public GameInputView build () {
            return new GameInputView(this.promptMessages);
        }
    }
}
