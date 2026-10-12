import java.util.ArrayList;
import java.util.Arrays;

public class AutoDraftRankingEngine {

    static class Player implements Comparable<Player> {

        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(String name, int matchesPlayed,
                      double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }

        static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 5 && !injured;
        }

        @Override
        public int compareTo(Player other) {
            return Double.compare(
                other.battingAverage,
                this.battingAverage
            );
        }

        static String draftAndRank(Player[] players) {

            ArrayList<Player> draftable = new ArrayList<>();

            for (Player player : players) {

                if (isDraftable(player.matchesPlayed) ||
                    isDraftable(player.matchesPlayed, player.injured)) {

                    draftable.add(player);
                }
            }

            Player[] ranked = draftable.toArray(new Player[0]);

            Arrays.sort(ranked);

            StringBuilder result = new StringBuilder();

            for (int i = 0; i < ranked.length; i++) {

                if (i > 0) {
                    result.append(" | ");
                }

                result.append(i + 1)
                      .append(". ")
                      .append(ranked[i].name);
            }

            return result.toString();
        }
    }

    public static void main(String[] args) {

        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(Player.draftAndRank(players));
    }
}
