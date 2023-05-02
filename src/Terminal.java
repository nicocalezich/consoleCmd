public class Terminal {

    private Command lastCommand;
    private Directory currentDir;
    private static Terminal terminal;

    private Terminal() {
        currentDir = new Directory(null, "C:");
    }

    private void determinateLastCommandStrategy(String input) {
        switch (input) {
            case "mkdir" -> this.lastCommand = new MkdirCommand();
            case "pwd" -> this.lastCommand = new PwdCommand();
            case "cd" -> this.lastCommand = new cdCommand();
            case "ls" -> this.lastCommand = new LsCommand();
            default -> throw new RuntimeException("Comando invalido");
        }
    }

    public void processInput(String input) throws RuntimeException {
        String command = input.split(" ")[0].trim();
        String parameter = input.split(" ").length > 1 ? input.split(" ")[1].trim() : "";
        determinateLastCommandStrategy(command);
        this.lastCommand.execute(parameter);
    }

    public Directory getCurrentDir() {
        return this.currentDir;
    }

    public void setCurrentDir(Directory currentDir) {
        this.currentDir = currentDir;
    }

    public static Terminal getInstance() {
        if (terminal == null) {
            terminal = new Terminal();
        }
        return terminal;
    }

}
