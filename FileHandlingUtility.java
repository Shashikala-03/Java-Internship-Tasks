import java.io.*;

public class FileHandlingUtility {
    public static void main(String[] args) {
        String fileName = "sample.txt";

        try {
            File file = new File(fileName);

            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

            FileWriter writer = new FileWriter(fileName);
            writer.write("Hello, this is a Java File Handling Task.\n");
            writer.write("This file is created during internship.\n");
            writer.close();

            System.out.println("Data written to file.");

            System.out.println("\nReading file content:");

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

            FileWriter modifyWriter = new FileWriter(fileName, true);
            modifyWriter.write("This line is added later.\n");
            modifyWriter.close();

            System.out.println("\nFile modified successfully.");

        } catch (IOException e) {
            System.out.println("Error occurred.");
        }
    }
}