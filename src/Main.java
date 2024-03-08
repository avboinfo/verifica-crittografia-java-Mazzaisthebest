import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String inputFileName = "static/data.txt";
        String encryptedFileName = "static/data.txt";
        String decryptedFileName = "static/data.txt";

        // Cripta il contenuto del file
        encryptFile(inputFileName, encryptedFileName);
        // Decripta il contenuto del file criptato
        decryptFile(encryptedFileName, decryptedFileName);
        // Stampare il contenuto del file decriptato
        printDecryptedContent(decryptedFileName);
    }
    public static void encryptFile(String inputFileName, String outputFileName) {
        try (Scanner scanner = new Scanner(new File(inputFileName));
             PrintWriter writer = new PrintWriter(outputFileName)) {
            int key = 3; // Chiave per l'algoritmo di Cesare
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                StringBuilder encryptedLine = new StringBuilder();
                for (char c : line.toCharArray()) {
                    char encryptedChar = (char) (c + key); // Algoritmo di Cesare
                    char xorChar = (char) (encryptedChar ^ 123); // Algoritmo XOR
                    encryptedLine.append(xorChar);
                }
                writer.println(encryptedLine.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void decryptFile(String inputFileName, String outputFileName) {
        try (Scanner scanner = new Scanner(new File(inputFileName));
             PrintWriter writer = new PrintWriter(outputFileName)) {
            int key = 3; // Chiave per l'algoritmo di Cesare
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                StringBuilder decryptedLine = new StringBuilder();
                for (char c : line.toCharArray()) {
                    char xorChar = (char) (c ^ 123); // Decriptazione dell'algoritmo XOR
                    char decryptedChar = (char) (xorChar - key); // Decriptazione dell'algoritmo di Cesare
                    decryptedLine.append(decryptedChar);
                }
                writer.println(decryptedLine.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void printDecryptedContent(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}