package com.android.carlos.loanapplication;

/**
 * Created by Carlos on 6/6/2015.
 */
public class LoanInvalidException extends RuntimeException {
    public LoanInvalidException(double m){
        super("El prestamo por "+m+" no es aceptado.");
    }
}
