package step3;

public class RacingGameApp {

	public static void main(String[] args) {
		
        InputView inputView = new InputView();
        int racingCars = inputView.setRacingCars();
        int racingRound = inputView.setRacingRound();
        
        Racing racing = new Racing(racingCars, racingRound);
        
        for(int i = 1; i <= racingRound; i++) {
        	System.out.println("-------------"+i+" Round------------");
        	ResultView.resultRacing(racing.gameStart());
        }
	}
}
