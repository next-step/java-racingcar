package racingcar.study.staticfactory.example;

/**
 * 3.하위 자료형 객체를 반환할 수 있다
 */
public class OrderUtil {

    public static final String COUPON = "coupon";
    public static final String POINT = "point";
    public static final int COUPON_NUMBER = 1000;
    public static final int POINT_NUMBER = 500;
    public static final String WRONG_DISCOUNT_CODE = "잘못된 할인 코드";
    public static final String ALREADY_USE_CODE = "이미 사용한 코드";

    public static Discount createDiscountItem(String discountCode) throws Exception {
        if (!isValidCode(discountCode)) {
            throw new Exception(WRONG_DISCOUNT_CODE);
        }
        // 쿠폰 코드인가? 포인트 코드인가?
        if (isUsableCoupon(discountCode)) {
            return new Coupon(COUPON_NUMBER);
        } else if (isUsablePoint(discountCode)) {
            return new Point(POINT_NUMBER);
        }
        throw new Exception(ALREADY_USE_CODE);
    }


    private static boolean isValidCode(String discountCode) {
        return isUsablePoint(discountCode) ||
                isUsableCoupon(discountCode);
    }

    private static boolean isUsableCoupon(String discountCode) {
        return discountCode.equals(COUPON);
    }

    private static boolean isUsablePoint(String discountCode) {
        return discountCode.equals(POINT);
    }
}
