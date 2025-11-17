import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class ConsonantExtractor {

    private static final Set<Character> CONSONANTS = Set.of(
            'б','в','г','д','ж','з','й','к','л','м',
            'н','п','р','с','т','ф','х','ц','ч','ш','щ'
    );

    public static List<Character> extractUniqueConsonants(String filePath) throws IOException {

        String text = Files.readString(Path.of(filePath));

        String[] words = text.toLowerCase()
                .replaceAll("[^а-яё\\s]", " ")
                .split("\\s+");

        Set<Character> uniqueSet = new HashSet<>();
        Set<Character> repeatedSet = new HashSet<>();

        for (String word : words) {
            Set<Character> localSet = new HashSet<>();

            for (char ch : word.toCharArray()) {
                if (CONSONANTS.contains(ch)) {
                    localSet.add(ch);
                }
            }

            for (char c : localSet) {
                if (!uniqueSet.contains(c) && !repeatedSet.contains(c)) {
                    uniqueSet.add(c);
                } else {
                    repeatedSet.add(c);
                }
            }
        }

        uniqueSet.removeAll(repeatedSet);

        List<Character> result = new ArrayList<>(uniqueSet);
        Collections.sort(result);
        return result;
    }
}
