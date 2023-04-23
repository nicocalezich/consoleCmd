public class PwdCommand implements Command {

    private static Terminal terminal = Terminal.getInstance();
    @Override
    public void execute(String parameter) throws RuntimeException {
        System.out.println(terminal.getCurrentDir().getAbsolutePath());
    }
}
