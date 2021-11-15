public class EnumValidator {
    public EnumValidator() {
    }

    public static boolean validateComponentType(String componentTypeStr) {
        ComponentType[] var1;
        var1 = ComponentType.values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ComponentType componentType = var1[var3];
            if (componentType.name().equals(componentTypeStr)) {
                return false;
            }
        }

        return true;
    }
}
