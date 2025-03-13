public class StringAddCalculator {
    public static Integer splitAndSum(String text) {
        if (isInvalid(text)) {
            return 0;
        }

        return sum(toIntegers(splitText(text)));
    }

    private static boolean isInvalid(String text) {
        return text == null || text.isEmpty();
    }

    private static int sum(Integer[] integers) {
        int sum = 0;
        for (Integer integer : integers) {
            sum += integer;
        }
        return sum;
    }

    private static Integer[] toIntegers(String[] strings) {
        Integer[] integers = new Integer[strings.length];

        for (int i = 0; i< strings.length; i++) {
            integers[i] = Integer.parseInt(strings[i]);
        }

        return integers;
    }

    private static String[] splitText(String text) {
        return text.split("[,:]");
    }
}
