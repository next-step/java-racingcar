package step1;

import java.util.ArrayList;
import java.util.List;

public class OperateCollection {
    private List<String> operates;

    public OperateCollection() {
        operates = new ArrayList<>();
    }

    public void add(String operate) {
        validateProperOperation(operate);
        operates.add(operate);
    }

    public boolean validateProperOperation(String operate) {
        if (!OperateEnum.validate(operate)) {
            throw new IllegalArgumentException(operate);
        }
        return true;
    }

    public int size() {
        return operates.size();
    }

    public String get(int index) {
        return operates.get(index);
    }

    public enum OperateEnum {
        PLUS("+"),
        MINUS("-"),
        MULTIPLY("*"),
        DIVIDE("/");

        private String name;

        OperateEnum(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public static boolean validate(String inputOperate) {
            int properCount = 0;

            for (OperateEnum type : OperateEnum.values()) {
                properCount = compareOperate(type.getName(), inputOperate, properCount);
            }

            if (properCount > 0) {
                return true;
            }
            return false;
        }

        private static int compareOperate(String type, String inputOperate, int properCount) {
            if (type.equals(inputOperate)) {
                properCount += 1;
            }
            return properCount;
        }
    }
}
