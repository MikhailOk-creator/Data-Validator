import java.io.*;

public class Main {
    public static void main(String[] args) {
        String inputFile = "test_input.txt";
        String outputFile = "test_output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length != 4) {
                    writer.write("||||");
                    writer.newLine();
                    continue;
                }

                String name = DataValidator.validateName(parts[0]);
                String age = DataValidator.validateAge(parts[1]);
                String phone = DataValidator.validatePhone(parts[2]);
                String email = DataValidator.validateEmail(parts[3]);

                writer.write(name + "|" + age + "|" + phone + "|" + email);
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}