package com.android.carlos.loanapplication;

import java.util.Calendar;

/**
 * Created by Carlos on 6/6/2015.
 */
public class Loan implements Loanable {
    protected String nombreCliente;
    protected int codigoPrestamo;
    protected double montoPrestamo, balance;
    protected Calendar fechaCreacion, fechaMaximaPago;

    public Loan(int loanCode, String client, double loanAmount) throws LoanInvalidException
    {
        if(loanAmount < 10000)
            throw new LoanInvalidException(loanAmount);
        this.codigoPrestamo = loanCode;
        this.nombreCliente = client;
        this.montoPrestamo = loanAmount;
        this.balance = loanAmount;
        fechaMaximaPago = Calendar.getInstance();
        fechaMaximaPago.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR)+5);
    }

    @Override
    public void pay(double monto) throws AlreadyPaidException
    {
        if(balance == 0)
            throw new AlreadyPaidException();
        if(Calendar.getInstance().after(fechaMaximaPago))
            balance -= (monto*.80);
        if(monto >= balance)
            balance = 0;
        else{
            balance -= monto;
            balance = Math.abs(balance);
        }


        System.out.println("Su nuevo balance es: "+balance);
    }

    @Override
    public double balanceDue()
    {
        return balance;
    }

    public void print()
    {
        System.out.println("- Codigo de Prestamo: "+codigoPrestamo+"\nNombre del Cliente: "+nombreCliente+
                "\nBalance: "+balance+"\nFecha Maxima de Pago: "+fechaMaximaPago.getTime());
        if(Calendar.getInstance().after(fechaMaximaPago))
            System.out.println("Esta en mora.");
    }

    public void updateFechaMaxima(String date)
    {
        try{
            String[] d = date.split("/");
            fechaMaximaPago.set(Integer.parseInt(d[0]),Integer.parseInt(d[1]),Integer.parseInt(d[2]));
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Formato de Fecha Incorrecto");
        }
    }

    public int getCodigoPrestamo() {
        return codigoPrestamo;
    }
}
