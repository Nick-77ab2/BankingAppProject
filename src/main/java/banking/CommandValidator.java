package banking;

public class CommandValidator {
    protected Bank bank;


    protected CommandValidator(Bank bank) {
        this.bank = bank;
    }

    public boolean calculateValidator(String command) {
        CreateCommandValidator createCommandValidator = new CreateCommandValidator(bank);
        DepositCommandValidator depositCommandValidator = new DepositCommandValidator(bank);
        WithdrawCommandValidator withdrawCommandValidator = new WithdrawCommandValidator(bank);
        PassTimeValidator passTimeValidator = new PassTimeValidator(bank);
        String[] splitCommand = command.split(" ");
        String commandType = splitCommand[0].toLowerCase();
        switch (commandType) {
            case "create":
                return createCommandValidator.validate(command);
            case "deposit":
                return depositCommandValidator.validate(command);
            case "withdraw":
                return withdrawCommandValidator.validate(command);
            case "pass":
                return passTimeValidator.validate(command);
            default:
                return false;
        }
    }

    public boolean isIDRightLength(String command) {
        return command.length() == 8;
    }

    public boolean idExists(String command) {
        return bank.accountExistsByID(command);
    }

    public boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isFloat(String input) {
        try {
            Float.parseFloat(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
