package carracing.views;

import carracing.util.StringUtil;

import java.util.*;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public InputView() {
    }

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String namesString = scanner.next();
        List<String> nameList = StringUtil.split(namesString);
        nameList.forEach(name -> {
            if (!StringUtil.checkWordLength(name))
                throw new IllegalArgumentException("이름은 5자를 넘을 수 없습니다.");
        });
        return nameList;
    }

    public int getTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
