package antistatic.spinnerwheel;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by islam on 3/30/2016.
 */
public class Util {

    private static Util instance;

    public static Util getInstance() {
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }

    /**
     * <p>Checks if two calendar objects  one bigger than other.</p>
     * <p>
     *
     * @param first  the first calendar, not altered, not null
     * @param second the second calendar, not altered, not null
     * @return true if first is bigger than second
     * @throws IllegalArgumentException if either calendar is <code>null</code>
     * @since 2.1
     */
    public static boolean isBiggerThan(Calendar first, Calendar second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        if (first.get(Calendar.YEAR) == second.get(Calendar.YEAR)) {
            return first.get(Calendar.DAY_OF_YEAR) > second.get(Calendar.DAY_OF_YEAR);
        } else {
            return first.get(Calendar.YEAR) > second.get(Calendar.YEAR);
        }
    }

    /**
     * <p>Checks if two calendar objects  equal in days.</p>
     * <p>
     *
     * @param first  the first calendar, not altered, not null
     * @param second the second calendar, not altered, not null
     * @return true if first is equal to second date
     * @throws IllegalArgumentException if either calendar is <code>null</code>
     * @since 2.1
     */
    public static boolean isCalendarEqual(Calendar first, Calendar second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return first.get(Calendar.YEAR) == second.get(Calendar.YEAR) &&
                first.get(Calendar.MONTH) == second.get(Calendar.MONTH) &&
                first.get(Calendar.DAY_OF_MONTH) == second.get(Calendar.DAY_OF_MONTH);
    }

    public static boolean isRTL() {
        return isRTL(Locale.getDefault());
    }

    private static boolean isRTL(Locale locale) {
        final int directionality = Character.getDirectionality(locale.getDisplayName().charAt(0));
        return directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT ||
                directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC;
    }

    /**
     * convert english number to Arabic number
     *
     * @param number the english number text
     * @return
     */
    public static String getLocalNumber(String number) {
        if (!isRTL()) {
            return number;
        }
        char[] arabicChars = {'٠', '١', '٢', '٣', '٤', '٥', '٦', '٧', '٨', '٩'};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))) {
                builder.append(arabicChars[(int) (number.charAt(i)) - 48]);
            } else {
                builder.append(number.charAt(i));
            }
        }
        return builder.toString();
    }

    /**
     * convert english number to Arabic number
     *
     * @param numberText the english number text
     * @return
     */
    public static String getLocalNumber(int numberText) {
        String number = String.valueOf(numberText);
        if (!isRTL())
            return number;
        char[] arabicChars = {'٠', '١', '٢', '٣', '٤', '٥', '٦', '٧', '٨', '٩'};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))) {
                builder.append(arabicChars[(int) (number.charAt(i)) - 48]);
            } else {
                builder.append(number.charAt(i));
            }
        }
        return builder.toString();
    }

    public static String getLocalNumber(double numberText) {
        String number = String.valueOf(numberText);
        if (!isRTL())
            return number;
        char[] arabicChars = {'٠', '١', '٢', '٣', '٤', '٥', '٦', '٧', '٨', '٩'};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))) {
                builder.append(arabicChars[(int) (number.charAt(i)) - 48]);
            } else {
                builder.append(number.charAt(i));
            }
        }
        return builder.toString();
    }

}
