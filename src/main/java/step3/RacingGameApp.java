package step3;

public class RacingGameApp {

	public static void main(String[] args) {
		
        InputView inputView = new InputView();
        int racingCars = inputView.setRacingCars();
        int racingRound = inputView.setRacingRound();
        
        Racing racing = new Racing(racingCars, racingRound);
        
        for (int i = 0; i < racingRound; i++) {
        	racing.setRacingResult(racing.getRacingCars());
        	System.out.println("----------"+(i+1)+"Round----------");
        	ResultView.resultRacing(racing.getRacingCars());
        }
        
	}
}
