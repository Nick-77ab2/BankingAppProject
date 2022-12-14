package banking;

import java.math.BigDecimal;

public class CD extends Account {
    private final int creationMonth = banking.PassTime.getCurrentTime();

    public CD(String id, float apr, double deposit) {
        super(id, apr, deposit);
        type = "cd";
    }

    @Override
    public void addBalance(String value) {
    }

    public int getCreationMonth() {
        return creationMonth;
    }

    @Override
    public void calculateAPR() {
        float calculateAPR = getApr();
        calculateAPR /= 100;
        calculateAPR /= 12;
        for (int times = 0; times < 4; times += 1) {
            BigDecimal quickBalance = balance;
            quickBalance = (quickBalance.multiply(BigDecimal.valueOf(calculateAPR)));
            balance = balance.add(quickBalance);
        }
    }
}
