import java.util.Arrays;

public class ThePlaylist {

    static class Playlist {
        private String[] songs;
        private int songCount;

        public Playlist(int capacity) {
            songs = new String[capacity];
            songCount = 0;
        }

        public void addSong(String song) {
            if (songCount < songs.length) {
                songs[songCount] = song;
                songCount++;
            } else {
                System.out.println("Playlist is full");
            }
        }

        public String[] getSongs() {
            return Arrays.copyOf(songs, songCount);
        }

        public int getSongCount() {
            return songCount;
        }
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        System.out.println(Arrays.toString(copy));

        copy[0] = "Hacked";

        System.out.println(Arrays.toString(p.getSongs()));
        System.out.println(p.getSongCount());
    }
}
