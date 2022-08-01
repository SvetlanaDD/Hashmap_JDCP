import java.util.HashMap;
import java.util.Map;

public class Main {
    public static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
            "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
            "laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate " +
            "velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt " +
            "in culpa qui officia deserunt mollit anim id est laborum.";

    public static char max(Map<Character, Integer> mapText) {
        int max = -1;
        char keyMax = ' ';
        for (Character key : mapText.keySet()) {
            if ((key != ' ') && (key != '.') && (key != ',')) {
                int value = mapText.get(key);
                if (value > max) {
                    max = value;
                    keyMax = key;
                }
            }
        }
        return keyMax;
    }

    public static char min(Map<Character, Integer> mapText) {
        int min = Integer.MAX_VALUE;
        char keyMin = ' ';
        for (Character key : mapText.keySet()) {
            if ((key != ' ') && (key != '.') && (key != ',')) {
                int value = mapText.get(key);

                if (value < min) {
                    min = value;
                    keyMin = key;
                }
            }
        }
        return keyMin;
    }

    public static void main(String[] args) {
        Map<Character, Integer> mapText = new HashMap<>();

        for (int index = 0; index < text.length(); index++) {
            char symb = text.charAt(index);
            if (mapText.get(symb) == null) {
                mapText.put(symb, 1);
            } else {
                int value = mapText.remove(symb);
                mapText.put(symb, value + 1);
            }
        }
        char maxChar = max(mapText);
        char minChar = min(mapText);
        System.out.println("В тексте чаще всего встречается буква '" + maxChar + "' (" + mapText.get(maxChar) + " раз)," +
                "а реже всего буква '" + minChar + "' (" + mapText.get(minChar) + " раз)");

    }
}
