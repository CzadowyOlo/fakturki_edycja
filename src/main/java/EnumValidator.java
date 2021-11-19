public class EnumValidator {
    public EnumValidator() {
    }
    public static boolean validateComponentType(String componentTypeStr) {
        ArticleGroup[] initial;
        initial = ArticleGroup.values();
        int elements = initial.length;



        for(int checker = 0; checker < elements; ++checker) {
            ArticleGroup articleGroup = initial[checker];
            if (articleGroup.name().equals(componentTypeStr)) {
                return false;
            }
        }

        return true;
    }
}
