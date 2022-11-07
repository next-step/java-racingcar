package carracing.views;

import carracing.domain.Name;
import carracing.util.StringUtil;

import java.util.*;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public InputView() {
    }

    public List<Name> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<String> namesStringList = StringUtil.split(scanner.next());
        List<Name> nameList = new ArrayList<>();

        namesStringList.forEach(name->nameList.add(new Name(name)));

        return nameList;
    }

    public int getTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
