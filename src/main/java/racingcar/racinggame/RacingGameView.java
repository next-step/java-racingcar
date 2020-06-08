package racingcar.racinggame;

import racingcar.common.ConsolePrintOutputView;
import racingcar.common.ConsoleScannerInputView;
import racingcar.common.Message;


public class RacingGameView implements RacingGameContract.View {
	private RacingGameContract.Presenter presenter;
	private ConsoleScannerInputView consoleScannerInputView;
	private ConsolePrintOutputView consolePrintOutputView;
	public final static String DEFAULT_CAR_POSITION_SYMBOL = "-";
	private String[] carNames;
	private int gameCount;

	@Override
	public void init() {
		presenter = new RacingGamePresenter();
		presenter.setView(this);
		consoleScannerInputView = new ConsoleScannerInputView();
		consolePrintOutputView = new ConsolePrintOutputView();
	}

	@Override
	public void println(String printMsg) {
		consolePrintOutputView.layout(printMsg);
	}

	public void print(String printMsg) {
		consolePrintOutputView.layoutWithoutEnter(printMsg);
	}

	@Override
	public void printCarPositionBySymbol(int position) {
		String result = "";

		for (int i = 0; i < position; i++) {
			result = result.concat(DEFAULT_CAR_POSITION_SYMBOL);
		}
		consolePrintOutputView.layout(result);
	}

	@Override
	public void layoutCarQuestion() {
		consoleScannerInputView.setLabel(Message.CAR_QUESTION_MSG);
		consoleScannerInputView.OnInputListener(input -> {
			if (input == null || input.isEmpty()) {
				println("자동차 이름을 입력해주세요.");
				layoutCarQuestion();
				return;
			}
			if (input.split(",").length == 1) {
				println("한대의 자동차는 경주를 할수 없습니다.");
				layoutCarQuestion();
				return;
			}
			carNames = input.split(",");
		});
		consoleScannerInputView.layout();
	}
	@Override
	public void layoutGameTryQuestion() {
		consoleScannerInputView.setLabel(Message.GAME_TRY_QUESTION_MSG);
		consoleScannerInputView.OnInputListener(input -> {
			try {
				this.gameCount = Integer.parseInt(input);
			} catch (Exception e) {
				println("정수의 숫자만 입력가능합니다.");
				layoutGameTryQuestion();
				return;
			}
			presenter.start(gameCount ,carNames);
		});

		consoleScannerInputView.layout();
	}



}
