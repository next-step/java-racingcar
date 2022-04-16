package study.step3;

public class ResultView {

    public void print(int round, Racingcar racingcar) {
        for(int i = 0; i < racingcar.getSuccessCount(); i++){
            System.out.print("-");
        }
        System.out.println(" ");
    }
}
