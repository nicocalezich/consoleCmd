public class MkdirCommand implements Command {

    private static Terminal terminal = Terminal.getInstance();

    @Override
    public void execute(String parameter) throws RuntimeException {
        terminal.getCurrentDir().addDir(parameter);
    }
}
