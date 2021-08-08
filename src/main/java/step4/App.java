package step4;

/*
 * 클래스 이름 : App
 * 버전 정보 : 0.0.1
 * 날짜 : 2021-08-07
 * 저작권 주의 : by MinYul
 */

public class App {

	public static void main(String[] args) {
		// 입력 역할 & 출력 역할
		InputConsole inputConsole = new InputConsole();
		inputConsole.setValues();
		ResultView resultView = new ResultView();

		// 제조기 전략 & 경기 생성
		NumberGenerator generator = new Generatorstrategy();
		Race race = new Race(generator, inputConsole.getCarNames());

		// 경기 시작 & 결과
		resultView.getResultComment();
		for(int raceIndex = 1; raceIndex <= inputConsole.getExecutionCount() ; raceIndex++) {
			race.startRace();
			resultView.viewResult(race.getCars());
		}
		resultView.winnerResult(race.getWinners());
	}
}
