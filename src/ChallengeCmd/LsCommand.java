package ChallengeCmd;

public class LsCommand implements Command{

    private static Terminal terminal = Terminal.getInstance();
    @Override
    public void execute(String parameter) throws RuntimeException {
        Directory directory = terminal.getCurrentDir();
        directory.getSubdirs().stream()
                .forEach(dir -> {
                    System.out.println("-" + dir.getDirName());
                });
    }
}
