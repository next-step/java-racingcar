package racingcar.racinggame;

import racingcar.common.CPrintOutputView;
import racingcar.common.CScannerInputView;
import racingcar.common.Message;

public class RacingGameView implements RacingGameContract.View {
	private RacingGameContract.Presenter presenter;
	private CScannerInputView carQuestionInputView;
	private CScannerInputView gameTryQuestionInputView;
	private CPrintOutputView cPrintOutputView;
	public final static String DEFAULT_CAR_POSITION_SYMBOL = "-";

	@Override
	public void init() {
		presenter = new RacingGamePresenter();
		presenter.setView(this);

		carQuestionInputView = new CScannerInputView();
		gameTryQuestionInputView = new CScannerInputView();
		cPrintOutputView = new CPrintOutputView();

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
	public void println(String printMsg) {
		cPrintOutputView.layout(printMsg);
	}

	public void print(String printMsg) {
		cPrintOutputView.layoutWithoutEnter(printMsg);
	}
	@Override
	public void printCarPositionBySymbol(int position) {
		String result = "";

		for (int i = 0; i < position; i++) {
			result = result.concat(DEFAULT_CAR_POSITION_SYMBOL);
		}
		cPrintOutputView.layout(result);
	}
}
