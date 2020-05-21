package study.nextstep.stage3;

import java.util.Scanner;

public class StandardInputView implements InputView {
    static StandardInputView view = new StandardInputView();
    private Scanner scanner = null;

    private StandardInputView(){}

    public static StandardInputView create(){
        if( view.scanner == null )
            view.scanner = new Scanner(System.in);
        return view;
    }

    @Override
    public int getCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    @Override
    public int getCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
