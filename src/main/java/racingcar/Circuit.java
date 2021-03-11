package racingcar;


public class Circuit {
    private int labCount;       // 현재 진행 랩
    private int lastLab;        // 목표 랩
    private boolean pitstop;    // 타이어교체 피트스톱 여부

    public Circuit(int lastLab) {
        this.labCount = 0;
        this.pitstop = false;
        this.lastLab = lastLab;
    }

    public void pitstop(int randomValue){
        if ((8 <= randomValue)
                && !(lastLab <= labCount)) {
            changePitstop();
        }
    }

    public boolean getPitstop() {
        return this.pitstop;
    }

    public int getPitstopPenalty() {
        int result = 0;
        if (this.pitstop) {
            changePitstop();
            result = 1;
        }
        return result;
    }

    public void changePitstop() {
        this.pitstop = !this.pitstop;
    }

    public int getLabCount() {
        return labCount;
    }

    public boolean finish() {
        if (labCount >= lastLab) {
            return true;
        }
        return false;
    }

    public void addLabCount(int i) {
        pitstop(RandomDice.getRandomValue());
        labCount+=i;
    }
}
