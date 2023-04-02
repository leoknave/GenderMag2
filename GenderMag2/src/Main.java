import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // Testing the Song class
        Song song1 = new Song(1000028, "Blinding Lights", "2021", "3:20");
        Song song2 = new Song(1000030, "Shape of You", "2021", "3:53");
        Song song3 = new Song(1000032, "Dance Monkey", "2021", "3:29");
        System.out.println(song1.toString());
        System.out.println(song2.getSongData3());
        song3.setSongData4(" ");
        System.out.println(song3.getSongData4());

        LinkedList<Song> songsList = new LinkedList<>();
        songsList.add(song1);
        songsList.add(song2);
        songsList.add(song3);

        Song.displayAllSongs(songsList);

        Song[] songsArray = Song.readSongsToArray();
        LinkedList<Song> songsListFromFile = Song.readSongsToList();

        Song searchedSong1 = Song.searchSongsByName("Song Title 1", songsArray);
        Song searchedSong2 = Song.searchSongsByYearAndName(2021, "Song Title 2", songsList);
       
        System.out.println(searchedSong1.toString());
        System.out.println(searchedSong2.getSongData3());

        Comparator<Song> songNameComparator = Song.getSongNameComparator();
        Comparator<Song> songYearAndNameComparator =        Song.getSongYearAndNameComparator();

        Arrays.sort(songsArray, songNameComparator);
        songsList.sort(songYearAndNameComparator);
}
    public static Song[] readSongsToArray(String filename) {
        ArrayList<Song> songs = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Song song = new Song(data[0], data[1], Integer.parseInt(data[2]), data[3]);
                songs.add(song);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return songs.toArray(new Song[0]);
    }
    public static LinkedList<Song> readSongsToList(String filename) {
        LinkedList<Song> songs = new LinkedList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Song song = new Song(data[0], data[1], Integer.parseInt(data[2]), data[3]);
                songs.add(song);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return songs;
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