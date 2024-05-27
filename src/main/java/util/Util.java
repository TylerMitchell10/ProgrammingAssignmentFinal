package util;

public class Util {
    public static String toTitleCase(String strIn) {
        if (strIn == null) {
            return null;
        }
        if (strIn.isEmpty()) {
            return "";
        }
        String[] strArray = strIn.split(" ");
        String strOut = "";
        for (String string : strArray) {
            String upperStr = string.substring(0, 1).toUpperCase();
            String lowerStr = string.substring(1).toLowerCase();
            strOut += upperStr + lowerStr + " ";
        }
        return strOut.substring(0, strOut.length() - 1);
    }
}
