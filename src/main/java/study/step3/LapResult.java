package study.step3;

class LapResult {
    private final Long id;
    private String name;
    private final Boolean moved;

    public LapResult(Long id, Boolean moved) {
        this.id = id;
        this.moved = moved;
    }

    public LapResult(String name, Boolean moved) {
        this(0L, moved);
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Boolean isMoved() {
        return moved;
    }

    public String getName() {
        return name;
    }
}
