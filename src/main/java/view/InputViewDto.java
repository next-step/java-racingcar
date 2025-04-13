package view;

public class InputViewDto {
    private final String name;
    private final int round;

    public InputViewDto(String name, int round) {
        this.name = name;
        this.round = round;
    }

    public String getName() {
        return name;
    }

    public int getRound() {
        return round;
    }
}
