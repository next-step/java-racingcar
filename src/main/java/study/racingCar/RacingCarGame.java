package study.racingCar;

public class RacingCarGame {

    public static void main(String[] args){
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        StringToIntConverter converter = new StringToIntConverter();
        String carNames = "";
        int tryCount = 0;

        try{

            carNames = inputView.inputCarNames();
            tryCount = converter.converter(inputView.inputTryCount());

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("시도할 횟수는 0보다 큰 숫자로만 입력해주세요.");
        }

    }

}
