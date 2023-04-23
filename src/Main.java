import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Terminal terminal = Terminal.getInstance();

        while (true) {
            System.out.print(terminal.getCurrentDir().getAbsolutePath() + "\\> ");
            String input = scan.nextLine();
            terminal.processInput(input);
        }
    }
}
