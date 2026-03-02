import java.util.*;

public class BannerApp {

    // Encapsulates character and its pattern
    static class CharacterPattern {
        private char character;
        private String[] pattern;

        public CharacterPattern(char character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        public char getCharacter() {
            return character;
        }

        public String[] getPattern() {
            return pattern;
        }
    }

    // Static inner class responsible for managing character-pattern mappings
    static class CharacterPatternMap {

        private static final Map<Character, CharacterPattern> patternMap = new HashMap<>();

        static {
            patternMap.put('O', new CharacterPattern('O', new String[]{
                    " ***** ",
                    "*     *",
                    "*     *",
                    "*     *",
                    " ***** "
            }));

            patternMap.put('P', new CharacterPattern('P', new String[]{
                    "****** ",
                    "*     *",
                    "****** ",
                    "*      ",
                    "*      "
            }));

            patternMap.put('S', new CharacterPattern('S', new String[]{
                    " ***** ",
                    "*      ",
                    " ***** ",
                    "      *",
                    " ***** "
            }));
        }

        public static CharacterPattern getPattern(char ch) {
            return patternMap.get(Character.toUpperCase(ch));
        }
    }

    public static void main(String[] args) {

        String text = "OOPS";
        int height = 5;

        StringBuilder[] bannerLines = new StringBuilder[height];

        for (int i = 0; i < height; i++) {
            bannerLines[i] = new StringBuilder();
        }

        for (char ch : text.toCharArray()) {
            CharacterPattern cp = CharacterPatternMap.getPattern(ch);

            if (cp != null) {
                String[] pattern = cp.getPattern();

                for (int i = 0; i < height; i++) {
                    bannerLines[i].append(pattern[i]).append("  ");
                }
            }
        }

        for (StringBuilder line : bannerLines) {
            System.out.println(line);
        }
    }
}
