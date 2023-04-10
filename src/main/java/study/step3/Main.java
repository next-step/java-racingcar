package study.step3;

public class Main {
    public static void main(String[] args) {
        // 입력 화면
        InputView inputView = new InputView();
        inputView.inputNumberOfAttempts();
        inputView.inputNumberOfCars();

        //출력화면
        ResultView resultView = new ResultView();

        //레이싱 경기장
        Track track = new Track(inputView.getAttemptCount(), resultView);
        track.setCar(inputView.getCarCount());
        track.startRacing();

    }
}
