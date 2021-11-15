public class NumberValidator {
    public NumberValidator() {
    }

    public static boolean validateDouble(String input, double min, double max) {
        if (input.matches("([0-9]+)(\\.[0-9]+)?")) {
            double value = Double.valueOf(input);
            if (value >= min && value <= max) {
                return true;
            }
        }

        return false;
    }

    public static boolean validateInteger(String input, int min, int max) {
        if (input.matches("[0-9]+")) {
            double value = (double)Integer.valueOf(input);
            if (value >= (double)min && value <= (double)max) {
                return true;
            }
        }

        return false;
    }
}
