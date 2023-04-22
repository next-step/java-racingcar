package racing.view;

public class InputDto {

    String input;
    int count;

    public InputDto(String input, int count) {
        this.input = input;
        this.count = count;
    }

    public String input() {
        return this.input;
    }

    public int count() {
        return this.count;
    }
}
