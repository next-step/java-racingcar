package javaracingcarwinner.dto;

public class GameSettingDto {

    private final String text;
    private final int tryCount;

    public GameSettingDto(final String text, final int tryCount) {
        this.text = text;
        this.tryCount = tryCount;
    }

    public String text() {
        return this.text;
    }

    public int tryCount() {
        return this.tryCount;
    }
}
