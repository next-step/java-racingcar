package step4;

/*
 * 클래스 이름 : App
 * 버전 정보 : 0.0.1
 * 날짜 : 2021-08-03
 * 저작권 주의 : by MinYul
 */

public class App {

	public static void main(String[] args) {
		// 입력 역할 & 출력 역할
		InputConsole inputConsole = new InputConsole();
		inputConsole.setValues();
		ResultView resultView = new ResultView();

		// 랜덤 숫자 제조기 & 경기 생성
		NumberContainer numberContainer = new NumberContainer();
		Race race = new Race(numberContainer, inputConsole.getCarNames());

		// 경기 시작 & 결과
		resultView.getResultComment();
		for(int raceIndex = 1; raceIndex <= inputConsole.getExecutionCount() ; raceIndex++) {
			race.startRace();
			resultView.viewResult(race.getCars());
		}
		resultView.winnerResult(race.getWinners());
	}
}
