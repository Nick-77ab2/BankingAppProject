package banking;

public class PassTimeCommandProcessor extends CommandProcessor {

    public PassTimeCommandProcessor(Bank bank) {
        super(bank);
    }

    public void processInput(String[] splitInput) {
        splitInput = removeCommandFromInput(splitInput);
        int time = Integer.parseInt(splitInput[0]);
        PassTime.passTime(time);
    }
}
