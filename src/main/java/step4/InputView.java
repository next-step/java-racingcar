package step4;

import javax.naming.InvalidNameException;
import java.util.*;


public class InputView {
    private Scanner scanner;
    private List<String> carNames;

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
        boolean isFirstAttempt = true;

        while (true) {
            if (isFirstAttempt) {
                System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
                isFirstAttempt = false;
            }

            String input = scanner.nextLine().trim();

            // 빈 입력값인 경우
            try {
                if (input.isEmpty()) {
                    throw new Exception("입력이 비어 있습니다. 자동차 이름을 입력해 주세요.");
                }
            } catch(Exception e) {
                System.out.println(e.getMessage());
                continue;
            }


            // 쉼표(,)를 포함하지 않는 경우
            if (!input.contains(",")) {
                System.out.println("쉼표(,)를 이용해 구분해 주세요.");
                continue;
            }

            String[] splitNames = input.split(",");
            List<String> names = new ArrayList<>();
            for (String name : splitNames) {
                String trimmedName = name.trim();
                if (!trimmedName.isEmpty()) {
                    names.add(trimmedName);
                }
            }

            // 이름이 2개 미만인 경우
            if (names.size() < 2) {
                System.out.println("경주를 위해 2개 이상의 차를 입력해 주세요.");
                continue;
            }


            Set<String> namesHash = new HashSet<>(names);
            try {
                for(String name:names) {
                    // 각 이름은 5글자를 초과할 수 없음.
                    if(name.length() > 5) {
                        throw new Exception("자동차 이름은 5글자까지만 가능해요!");
                    }

                    // 각 이름은 달라야하며 동명 자동차 존재할 수 없음.
                    if(names.size()!= namesHash.size()){
                        throw new Exception("자동차 이름은 중복될 수 없어요!");
                    }
                }
            } catch(Exception e) {
                System.out.println(e.getMessage());
                continue;
            }

            return names; // 유효한 입력값이 있으면 반환
        }
    }
}
