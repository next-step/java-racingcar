package study.step3;

class LapResult {
    private final String name;
    private final Boolean moved;

    public LapResult(String name, Boolean moved) {
        this.moved = moved;
        this.name = name;
    }

    public Boolean isMoved() {
        return moved;
    }

    public String getName() {
        return name;
    }
}
