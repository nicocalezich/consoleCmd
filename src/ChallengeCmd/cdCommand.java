package ChallengeCmd;

import java.util.List;

public class cdCommand implements Command {
    private static Terminal terminal = Terminal.getInstance();
    private static String goBackParam = "..";
    @Override
    public void execute(String parameter) throws RuntimeException {
        Directory dir = terminal.getCurrentDir();

        if (parameter.equals(goBackParam)) {
            terminal.setCurrentDir(terminal.getCurrentDir().getParentDir());
            return;
        }

        List<Directory> subdirs = dir.getSubdirs();
        Directory selectedDir = subdirs.stream()
                .filter(subdir -> subdir.getDirName().equals(parameter))
                .findFirst()
                .orElse(null);

        terminal.setCurrentDir(selectedDir != null ? selectedDir : dir);

    }
}
