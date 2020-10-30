package study;

class LapResult {
    private final Long id;
    private final Boolean moved;

    public LapResult(Long id, Boolean moved) {
        this.id = id;
        this.moved = moved;
    }

    public Long getId() {
        return id;
    }

    public Boolean isMoved() {
        return moved;
    }
}
