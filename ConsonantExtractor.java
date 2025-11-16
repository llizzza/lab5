import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class ConsonantExtractor {

    private static final Set<Character> CONSONANTS = Set.of (
            'б','в','г','д','ж','з','й','к','л','м','н','п','р','с','т','ф','х','ц','ч','ш','щ');

    public static List<Character> extractUniqueConsonants(String filePath) throws IOException {

        String text = Files.readString(Path.of(filePath));

        String[] words = text.toLowerCase().replaceAll("[^а-яё\\s]", " ").split("\\s+");

        Map<Character, Set<Integer>> letterToWordIds = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                if (CONSONANTS.contains(ch)) {
                    letterToWordIds.computeIfAbsent(ch, k -> new HashSet<>()).add(i);
                }
            }
        }

        List<Character> result = new ArrayList<>();
        for (var entry : letterToWordIds.entrySet()) {
            if (entry.getValue().size() == 1) {
                result.add(entry.getKey());
            }
        }

        Collections.sort(result);
        return result;
    }
}
