package step4;

import java.util.*;
import java.util.regex.Pattern;

public class InputView {
    private Scanner scanner;
    private List<String> carNames;

    private int attemptCount = 0;
    private static final int MAX_ATTEMPTS = 10;
    private static final Pattern VALID_CAR_NAME_PATTERN = Pattern.compile("^[\\w가-힣]+(,[\\w가-힣]+)*$");

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getCarCountFromUser() {
        if(carNames == null) {
            carNames = new ArrayList<>();
        }
        return this.carNames.size();
    }

    public int getRoundCountFromUser() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    public List<String> getCarNamesFromUser() {
        if (attemptCount >= MAX_ATTEMPTS) {
            throw new IllegalStateException("입력을 너무 많이 실패했습니다.");
        }
        attemptCount++;

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String input = scanner.nextLine().trim();

        // 입력값 검증
        if (isInputEmpty(input)) {
            return getCarNamesFromUser();
        }

        if (isInvalidCarNameFormat(input)) {
            return getCarNamesFromUser();
        }

        List<String> names = parseCarNames(input);

        if (hasInsufficientCarNames(names)) {
            return getCarNamesFromUser();
        }

        if (isInvalidCarName(names)) {
            return getCarNamesFromUser();
        }

        this.carNames = names;

        return names;
    }


    private boolean isInputEmpty(String input) {
        if (input.isEmpty()) {
            System.out.println("입력이 비어 있습니다. 자동차 이름을 입력해 주세요.");
            return true;
        }
        return false;
    }


    public static boolean isInvalidCarNameFormat(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("값을 입력해 주세요.(예: 자동차, 열차, 비행기)");
            return true;
        }

        if(!VALID_CAR_NAME_PATTERN.matcher(input).matches()){
            System.out.println("입력 형식이 올바른지 확인해 주세요.(예: 자동차, 열차, 비행기)");
            return true;
        };

        return false;
    }

    private List<String> parseCarNames(String input) {
        String[] splitNames = input.split(",");
        List<String> names = new ArrayList<>();
        for (String name : splitNames) {
            String trimmedName = name.trim();
            if (!trimmedName.isEmpty()) {
                names.add(trimmedName);
            }
        }
        return names;
    }

    private boolean hasInsufficientCarNames(List<String> names) {
        if (names.size() < 2) {
            System.out.println("경주를 위해 2개 이상의 차를 입력해 주세요.");
            return true;
        }
        return false;
    }

    private boolean isInvalidCarName(List<String> names) {

        if(isCarNameLongerThan5(names)) return true;

        if(isCarNameDuplicated(names)) return true;

        return false;
    }

    private boolean isCarNameLongerThan5 (List<String> names) {
        for (String name : names) {
            if (name.length() > 5) {
                System.out.println("자동차 이름은 5글자까지만 가능해요!");
                return true;
            }
        }
        return false;
    }

    private boolean isCarNameDuplicated(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        if (uniqueNames.size() != names.size()) {
            System.out.println("자동차 이름은 중복될 수 없어요!");
            return true;
        }
        return false;
    }
}
