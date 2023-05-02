public class LsCommand implements Command {

    private static final Terminal terminal = Terminal.getInstance();

    @Override
    public void execute(String parameter) throws RuntimeException {
        Directory directory = terminal.getCurrentDir();
        directory.getSubdirs()
                .forEach(dir -> System.out.println(dir.getDirName()));
    }
}
