import java.util.*;

public class RecommendationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample data
        Map<String, List<String>> data = new HashMap<>();

        data.put("movies", Arrays.asList("Avengers", "Batman", "Spider-Man"));
        data.put("books", Arrays.asList("Harry Potter", "Lord of the Rings", "Sherlock Holmes"));
        data.put("music", Arrays.asList("Arijit Singh", "Taylor Swift", "Ed Sheeran"));

        System.out.println("Enter your interest (movies/books/music): ");
        String choice = sc.nextLine().toLowerCase();

        if (data.containsKey(choice)) {
            System.out.println("Recommended for you:");
            for (String item : data.get(choice)) {
                System.out.println("- " + item);
            }
        } else {
            System.out.println("No recommendations found.");
        }

        sc.close();
    }
}