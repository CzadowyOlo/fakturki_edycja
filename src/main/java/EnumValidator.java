public class EnumValidator {
    public EnumValidator() {
    }

    public static boolean validateComponentType(String componentTypeStr) {
        ArticleGroup[] var1;
        var1 = ArticleGroup.values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ArticleGroup articleGroup = var1[var3];
            if (articleGroup.name().equals(componentTypeStr)) {
                return false;
            }
        }

        return true;
    }
}
