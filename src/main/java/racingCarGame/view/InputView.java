package racingCarGame.view;

import java.util.List;

public class InputView {
    private final List<String> owners;
    private final int tryCount;

    public InputView(String owners, int tryCount) {
        this.owners = List.of(owners.split(","));
        for (String owner : this.owners) {
            validateOwnerLength(owner);
        }
        this.tryCount = tryCount;
    }

    private void validateOwnerLength(String owner) {
        if (owner.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public int getTryCount() {
        return tryCount;
    }
    public List<String> getOwners() {
        return owners;
    }
}
