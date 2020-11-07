package study1.step3;

public class RaceSetting {
    private final InputView inputView;

    public RaceSetting(){
        this.inputView = new InputView();
    }

    public int getCarCnt(){
        return this.inputView.getAnswer("자동차 대수는 몇 대 인가요?");
    }

    public int getRaceCnt(){
        return this.inputView.getAnswer("시도할 회수는 몇 회 인가요?");
    }

    public void finishSetting(){
        this.inputView.close();
    }
}
