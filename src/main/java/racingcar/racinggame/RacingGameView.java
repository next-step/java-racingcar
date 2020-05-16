package racingcar.racinggame;

import racingcar.common.CScannerInputView;
import racingcar.common.Message;
import racingcar.common.MessageType;

public class RacingGameView implements RacingGameContract.View {	
	private RacingGameContract.Presenter presenter;
	private CScannerInputView carQuestionInputView;
	private CScannerInputView gameTryQuestionInputView;
	
	@Override
	public void init() {
		presenter = new RacingGamePresenter();
		presenter.setView(this);

		carQuestionInputView = new CScannerInputView();
		gameTryQuestionInputView = new CScannerInputView();

		carQuestionInputView.setLabel(Message.CAR_QUESTION_MSG);
		gameTryQuestionInputView.setLabel(Message.GAME_TRY_QUESTION_MSG);

		carQuestionInputView.OnInputListener(input -> {
			presenter.addCars(input);
			gameTryQuestionInputView.layout();
		});
		
		gameTryQuestionInputView.OnInputListener(input -> {
			presenter.setGameNum(input);
			presenter.start();
		});

		carQuestionInputView.layout();
	}

	@Override
	public void print(String printMsg ) {
		System.out.println(printMsg);
	}
}
