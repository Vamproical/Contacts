package contacts.command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class isCorrectNumber {
    public static boolean isCorrect(String number) {
        String withoutParentheses = "[+]?[\\da-z]+([ -][\\da-z]{2,})*";
        String firstGroupParentheses = "[+]?\\([\\da-z]+\\)([ -][\\da-z]{2,})*";
        String secondGroupParentheses = "[+]?[\\da-z]+([ -][\\da-z]{2,})*([ -]\\([\\da-z]{2,})\\)([ -][\\da-z]{2,})*";
        Pattern pattern = Pattern.compile(withoutParentheses +
                "|" + firstGroupParentheses +
                "|" + secondGroupParentheses, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
}
