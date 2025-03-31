package view;

public class PositionFormatter {
    private final Integer position;

    public PositionFormatter(Integer position) {
        this.position = position;
    }

    public String formatPosition(String pattern) {
        return pattern.repeat(position + 1);
    }
}
