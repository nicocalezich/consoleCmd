public interface Command {

    void execute(String parameter) throws RuntimeException;
}
