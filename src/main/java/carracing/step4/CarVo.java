package carracing.step4;

public class CarVo {
    private final String name;
    private final int moveCnt;

    public CarVo(String name, int moveCnt) {
        this.name = name;
        this.moveCnt = moveCnt;
    }

    public String getName() {
        return name;
    }

    public int getMoveCnt() {
        return moveCnt;
    }
}
