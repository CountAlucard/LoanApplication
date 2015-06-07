package com.android.carlos.loanapplication;

/**
 * Created by Carlos on 6/6/2015.
 */
public interface Loanable {
    void pay(double monto) throws AlreadyPaidException;
    double balanceDue();
}
