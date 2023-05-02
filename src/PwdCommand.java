public class PwdCommand implements Command {

    private static final Terminal terminal = Terminal.getInstance();
    @Override
    public void execute(String parameter) throws RuntimeException {
        System.out.println(terminal.getCurrentDir().getAbsolutePath());
    }
}
