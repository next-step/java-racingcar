package racingcar.racinggame;

public interface RacingGameContract {
	interface View {
		void init();
		void print(String msg);
		void println(String msg);
		void printCarPositionBySymbol(int position);
		void layoutCarQuestion();
		void layoutGameTryQuestion();
	}

	interface Presenter {
		void setView(View view);
		void start(int gameCount, String[] carNames);
	}
}
