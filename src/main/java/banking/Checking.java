package banking;

import java.math.BigDecimal;

public class Checking extends Account {

    Checking(String id, float apr) {
        super(id, apr);
        type = "checking";
    }

    @Override
    public void addBalance(String value) {
        BigDecimal add = new BigDecimal(value);
        balance = balance.add(add);
    }
}
