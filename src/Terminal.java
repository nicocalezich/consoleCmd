public class Terminal {

    private Directory rootDir;
    private Command lastCommand;
    private Directory currentDir;
    private static Terminal terminal;

    private Terminal() {
        this.rootDir = new Directory(null, "C:");
        currentDir = rootDir;
    }

    private void determinateLastCommandStrategy(String input) {
        if (input.equals("mkdir")) {
            this.lastCommand = new MkdirCommand();
        } else if (input.equals("pwd")) {
            this.lastCommand = new PwdCommand();
        } else if (input.equals("cd")) {
            this.lastCommand = new cdCommand();
        } else if (input.equals("ls")) {
            this.lastCommand = new LsCommand();
        } else {
            throw new RuntimeException("Comando invalido");
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
