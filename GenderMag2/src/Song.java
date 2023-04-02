import java.util.*;

class Song {
    private Object songData1;
    private Object songData2;
    private Object songData3;
    private Object songData4;

    public Song(Object songData1, Object songData2, Object songData3, Object songData4) {
        this.songData1 = songData1;
        this.songData2 = songData2;
        this.songData3 = songData3;
        this.songData4 = songData4;
    }

    public Object getSongData1() {
        return songData1;
    }

    public void setSongData1(Object songData1) {
        this.songData1 = songData1;
    }

    public Object getSongData2() {
        return songData2;
    }

    public void setSongData2(Object songData2) {
        this.songData2 = songData2;
    }

    public Object getSongData3() {
        return songData3;
    }

    public void setSongData3(Object songData3) {
        this.songData3 = songData3;
    }

    public Object getSongData4() {
        return songData4;
    }

    public void setSongData4(Object songData4) {
        this.songData4 = songData4;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songData1=" + songData1 +
                ", songData2=" + songData2 +
                ", songData3=" + songData3 +
                ", songData4=" + songData4 +
                '}';
    }

    public static void displayAllSongs(LinkedList<Song> songs) {
        for (Song song : songs) {
            System.out.println(song.getSongData1() + ", " + song.getSongData2() + ", " + song.getSongData3());
        }
    }

    public static Song[] readSongsToArray() {
        // Implementation for reading from file and converting to array
        return new Song[0];
    }

    public static LinkedList<Song> readSongsToList() {
        // Implementation for reading from file and converting to LinkedList
        return new LinkedList<>();
    }

    public static Song searchSongsByName(String name, Song[] songs) {
        for (Song song : songs) {
            if (song.getSongData1().equals(name)) {
                return song;
            }
        }
        return null;
    }

    public static Song searchSongsByYearAndName(int year, String name, LinkedList<Song> songs) {
        for (Song song : songs) {
            if (song.getSongData1().equals(name) && (int) song.getSongData2() == year) {
                return song;
            }
        }
        return null;
    }

    public static Comparator<Song> getSongNameComparator() {
        return Comparator.comparing(s -> s.getSongData1().toString());
    }

    public static Comparator<Song> getSongYearAndNameComparator() {
        return Comparator.comparing((Song s) -> (int) s.getSongData2())
                .thenComparing(s -> s.getSongData1().toString());
    }
}