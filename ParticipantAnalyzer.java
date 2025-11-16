import java.util.*;

public class ParticipantAnalyzer {
    public static List<Participant> getWinners(List<Participant> participants) {
        List<Participant> winners = new ArrayList<>();

        int maxScore = -1;
        for (Participant p : participants) {
            int total = p.getTotalScore();
            if (total > maxScore) {
                maxScore = total;
                winners.clear();
                winners.add(p);
            } else if (total == maxScore) {
                winners.add(p);
            }
        }

        return winners;
    }
}
