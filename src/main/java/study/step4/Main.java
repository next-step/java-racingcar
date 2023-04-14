package study.step4;

public class Main {

    public static void main(String[] args) {
        // 입력 화면
        String carNames = InputView.askCarName();
        int finish = InputView.aksFinishCount();

        //레이싱 경기장
        Track track = new Track(carNames, finish);
        while (!track.isRaceEnd()) {
            track.startRacing();
            ResultView.outPut(track);
        }
        track.determineWinner();

        //레이싱 우승자 출력
        ResultView.outPutWinner(track);
    }
}
