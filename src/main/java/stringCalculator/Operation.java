package stringCalculator;

public interface Operation {
    String apply(String a, String b);
}

enum FourOperation implements Operation {
    PLUS("+"){
        public String apply(String a, String b) {
            return (Integer.parseInt(a) + Integer.parseInt(b))+"";
        }
    },
    MINUS("-"){
        public String apply(String a, String b) {
            return (Integer.parseInt(a) - Integer.parseInt(b))+"";
        }
    },
    MULT("+"){
        public String apply(String a, String b) {
            return (Integer.parseInt(a) * Integer.parseInt(b))+"";
        }
    },
    DIVIDE("+"){
        public String apply(String a, String b) {
            return (Integer.parseInt(a) / Integer.parseInt(b))+"";
        }
    };

    private final String value;

    FourOperation(String value) {
        this.value = value;
    }
}
