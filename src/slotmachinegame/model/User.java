package slotmachinegame.model;

import java.time.LocalDateTime;

public class User {

    private String userName;
    private LocalDateTime dateOfAccountCreation;
    private double currency;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getDateOfAccountCreation() {
        return dateOfAccountCreation;
    }

    public void setDateOfAccountCreation(LocalDateTime dateOfAccountCreation) {
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
}
