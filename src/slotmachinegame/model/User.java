package slotmachinegame.model;

import java.time.LocalDate;
import java.util.Objects;

public class User {

    private String userName;
    private LocalDate dateOfAccountCreation;
    private double currency;

    public User(String userName){
        this.userName = userName;
        dateOfAccountCreation = LocalDate.now();
        currency = 100;

    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getDateOfAccountCreation() {
        return dateOfAccountCreation;
    }

    public void setDateOfAccountCreation(LocalDate dateOfAccountCreation) {
        this.dateOfAccountCreation = dateOfAccountCreation;
    }

    public double getCurrency() {
        return currency;
    }

    public void setCurrency(double currency) {
        this.currency = currency;
    }

    public void addCurrency(double addCurrency){
        currency += addCurrency;
    }

    public void removeCurrency(double currencyToRemove){
        if(currencyToRemove > currency){
            currency = 0;
        }
        currency -= currencyToRemove;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Double.compare(user.currency, currency) == 0 &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(dateOfAccountCreation, user.dateOfAccountCreation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, dateOfAccountCreation, currency);
    }
}
