package racingcar.racinggame;

public interface RacingGameContract {
	interface View {
		void init();
		void print(String msg);
		void printCarPositionBySymbol(int position);
	}

	interface Presenter {
		void setView(View view);
		void start();
		void setGameNum(int number);
		void addCars(int number);
	}
	
}
