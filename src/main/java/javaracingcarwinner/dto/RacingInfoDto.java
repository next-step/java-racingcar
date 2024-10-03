package javaracingcarwinner.dto;

public class RacingInfoDto {

    private final String text;
    private final int tryCount;

    public RacingInfoDto(final String text, final int tryCount) {
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
