public class StringValidator {
    public StringValidator() {
    }

    public static boolean validateString(String input, String regex) {
        return input.matches(regex);
    }
}
