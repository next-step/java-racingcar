package study;

public class RacingCarGameManager {
    public static void main(String[] args) {
        InputView.displayMessage("자동차 대수는 몇 대 인가요?");
        int numberOfCars = InputView.getUserInput();

        InputView.displayMessage("시도할 회수는 몇 회 인가요?");
        int numberOfRounds = InputView.getUserInput();

        RacingCarGame game = new RacingCarGame(numberOfCars, numberOfRounds);
        game.run();

        ResultView resultView = new ResultView();
        resultView.displayResult(game);
    }
}

/*
* 하지만 message, counts 같은 class 변수가 필요할 까요??
사용자로부터 입력을 받아 그 입력을 사용하려고 하는 객체에게 값을 전달하면
이 객체의 역할은 끝이 납니다 😄
굳이 InputView가 그 값을 가지고 있을 이유는 많이 없어 보입니다 (자신이 쓰는 곳이 없습니다)

한번 개선 검토 부탁 드립니다 🙇
* */