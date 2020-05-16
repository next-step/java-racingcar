package racingcar.racinggame;

import racingcar.common.MessageType;

public interface RacingGameContract {
	interface View {
		void init();
		void print(String msg);
	}

	interface Presenter {
		void setView(View view);
		void start();
		void setGameNum(int number);
		void addCars(int number);
	}
	
}
