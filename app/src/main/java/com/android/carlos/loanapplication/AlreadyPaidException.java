package com.android.carlos.loanapplication;

/**
 * Created by Carlos on 6/6/2015.
 */
public class AlreadyPaidException extends RuntimeException{
    public AlreadyPaidException(){
        super("Prestamo ya pagado!");
    }
}
