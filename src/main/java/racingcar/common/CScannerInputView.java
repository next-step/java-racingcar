package racingcar.common;

import java.util.Scanner;

public class CScannerInputView {
	private Scanner scan;
	private String label;
	private int value;
	private onInputListener listener;

	public interface onInputListener {
		void onInput(int input);
	}
	
	public CScannerInputView() {
		this.init();
	}
	
	public void init() {
		scan = new Scanner(System.in);
	}
	
	public void setLabel(String label) {
		this.label = label;
	}

	public void layout() {
		System.out.println(label);
		value = scan.nextInt();
		listener.onInput(value);
	}
	
	public void OnInputListener(onInputListener lisner) {
		this.listener = lisner;
	}
	
}
