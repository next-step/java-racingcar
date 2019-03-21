package racinggame.dto;

public class WebGameDto {
    private String player;
    private int moveDistance;

    public WebGameDto(String player) {
        this.player = player;
        this.moveDistance = 0;
    }
    public String getPlayer() {
        return player;
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    public void setMoveDistance(int moveDistance) {
        this.moveDistance = moveDistance;
    }
}

