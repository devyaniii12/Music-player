import java.util.*;

class MusicPlayer {
    private Stack<String> recent; // Recently played (Stack)
    private Queue<String> playlist; // Playlist (Queue)

    public MusicPlayer() {
        recent = new Stack<>();
        playlist = new LinkedList<>();
    }

    // Add song to playlist
    public void addSong(String song) {
        playlist.offer(song);
        System.out.println(song + " added to playlist.");
    }

    // Play a song from playlist
    public void playSong() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        String song = playlist.poll(); // Dequeue
        System.out.println("Now Playing: " + song);
        recent.push(song); // Add to stack
    }

    // Show playlist
    public void showPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        System.out.println("Playlist:");
        for (String s : playlist) {
            System.out.println(" - " + s);
        }
    }

    // View recently played songs
    public void viewRecent() {
        if (recent.isEmpty()) {
            System.out.println("No recently played songs.");
            return;
        }
        System.out.println("Recently played:");
        for (int i = recent.size() - 1; i >= 0; i--) {
            System.out.println(" - " + recent.get(i));
        }
    }

    // Last played song
    public void lastPlayed() {
        if (recent.isEmpty()) {
            System.out.println("No last played song.");
            return;
        }
        System.out.println("Last Played: " + recent.peek());
    }

    // Search in playlist + recent
    public void searchSong(String song) {
        if (playlist.contains(song) || recent.contains(song)) {
            System.out.println(song + " found in collection.");
        } else {
            System.out.println(song + " not found.");
        }
    }

    // Delete song from playlist
    public void deleteSong(String song) {
        if (playlist.remove(song)) {
            System.out.println(song + " removed from playlist.");
        } else {
            System.out.println(song + " not found in playlist.");
        }
    }

    // Sort playlist alphabetically
    public void sortPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        List<String> sortedList = new ArrayList<>(playlist);
        Collections.sort(sortedList);
        System.out.println("Sorted Playlist:");
        for (String s : sortedList) {
            System.out.println(" - " + s);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MusicPlayer player = new MusicPlayer();

        while (true) {
            System.out.println("\n=== MUSIC PLAYER MENU ===");
            System.out.println("1. Add Song");
            System.out.println("2. Play Song");
            System.out.println("3. Show Playlist");
            System.out.println("4. Recently Played");
            System.out.println("5. Last Played");
            System.out.println("6. Search Song");
            System.out.println("7. Delete Song");
            System.out.println("8. Sort Playlist");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter song name: ");
                    String song = sc.nextLine();
                    player.addSong(song);
                    break;
                case 2:
                    player.playSong();
                    break;
                case 3:
                    player.showPlaylist();
                    break;
                case 4:
                    player.viewRecent();
                    break;
                case 5:
                    player.lastPlayed();
                    break;
                case 6:
                    System.out.print("Enter song name: ");
                    String s = sc.nextLine();
                    player.searchSong(s);
                    break;
                case 7:
                    System.out.print("Enter song name: ");
                    String d = sc.nextLine();
                    player.deleteSong(d);
                    break;
                case 8:
                    player.sortPlaylist();
                    break;
                case 9:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
