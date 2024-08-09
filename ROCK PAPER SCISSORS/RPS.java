import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    private static int botScore = 0;
    private static int userScore = 0;
    private static int drawScore = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] choices = {"Rock", "Paper", "Scissors"};

        while (true) {
            System.out.println("Enter Rock, Paper, or Scissors. Type 'exit' to quit.");
            String userChoice = scanner.nextLine();
            
            if (userChoice.equalsIgnoreCase("exit")) {
                break;
            }

            if (!isValidChoice(userChoice)) {
                System.out.println("Invalid choice. Please enter Rock, Paper, or Scissors.");
                continue;
            }

            String botChoice = getBotChoice(choices);
            System.out.println("Bot chose: " + botChoice);

            String result = getResult(userChoice, botChoice);
            updateScores(result);
            System.out.println(result);
            displayScores();
        }

        scanner.close();
    }

    private static boolean isValidChoice(String choice) {
        return choice.equalsIgnoreCase("Rock") || choice.equalsIgnoreCase("Paper") || choice.equalsIgnoreCase("Scissors");
    }

    private static String getBotChoice(String[] choices) {
        Random random = new Random();
        return choices[random.nextInt(choices.length)];
    }

    private static String getResult(String userChoice, String botChoice) {
        if (userChoice.equalsIgnoreCase(botChoice)) {
            return "It's a draw!";
        }

        switch (userChoice.toLowerCase()) {
            case "rock":
                return botChoice.equalsIgnoreCase("Scissors") ? "You win!" : "Bot wins!";
            case "paper":
                return botChoice.equalsIgnoreCase("Rock") ? "You win!" : "Bot wins!";
            case "scissors":
                return botChoice.equalsIgnoreCase("Paper") ? "You win!" : "Bot wins!";
            default:
                return "Unexpected error.";
        }
    }

    private static void updateScores(String result) {
        switch (result) {
            case "You win!":
                userScore++;
                break;
            case "Bot wins!":
                botScore++;
                break;
            case "It's a draw!":
                drawScore++;
                break;
        }
    }

    private static void displayScores() {
        System.out.println("Scores - Bot: " + botScore + " | Draws: " + drawScore + " | You: " + userScore);
    }
}