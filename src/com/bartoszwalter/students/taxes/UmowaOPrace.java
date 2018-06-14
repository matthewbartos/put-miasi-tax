package com.bartoszwalter.students.taxes;

import java.text.DecimalFormat;

public class UmowaOPrace extends Umowa {
    private double zaliczkaNaPodatekDochodowy = 0;
    private double zaliczkaUS = 0;
    private double zaliczkaUSZaokr = 0;
    private double oPodstawa = 0;
    private double podstawaOpodat = 0;
    private double podstawaOpodatZaokr = 0;
    private double podatekPotracony = 0;
    private double wynagrodzenie = 0;
    private double kosztyUzyskania = 111.25;
    DecimalFormat df = new DecimalFormat("#");

    public void obliczKoszty(double podstawa) {
        podstawaOpodat = oPodstawa - 111.25;
        podstawaOpodatZaokr = Double.parseDouble(df.format(podstawaOpodat));
        zaliczkaNaPodatekDochodowy = obliczPodatek(podstawaOpodatZaokr);
        podatekPotracony = zaliczkaNaPodatekDochodowy - kwotaZmiejszajacaPodatek;
        zaliczkaUS = obliczZaliczke();
        zaliczkaUSZaokr = Double.parseDouble(df.format(zaliczkaUS));
        wynagrodzenie = podstawa - ((SkladkaEmerytalna + SkladkaRentowa + UbezpChorobowe) + SkladkaZdrowotna1 + zaliczkaUSZaokr);
    }

    public void wypiszKoszty(double podstawa) {
        DecimalFormat df00 = new DecimalFormat("#.00");
        System.out.println("UMOWA O PRACĘ");
        System.out.println("Koszty uzyskania przychodu w stałej wysokości " + kosztyUzyskania);
        System.out.println("Podstawa opodatkowania " + podstawaOpodat
                + " zaokrąglona " + df.format(podstawaOpodatZaokr));
        System.out.println("Zaliczka na podatek dochodowy 18 % = " + zaliczkaNaPodatekDochodowy);
        System.out.println("Kwota wolna od podatku = " + kwotaZmiejszajacaPodatek);
        System.out.println("Podatek potrącony = " + df00.format(podatekPotracony));
        System.out.println("Zaliczka do urzędu skarbowego = "
                + df00.format(zaliczkaUS) + " po zaokrągleniu = "
                + df.format(zaliczkaUSZaokr));
        System.out.println();
        System.out.println("Pracownik otrzyma wynagrodzenie netto w wysokości = "
                        + df00.format(wynagrodzenie));
    }

    public double obliczZaliczke() {
            return zaliczkaNaPodatekDochodowy - SkladkaZdrowotna2 - kwotaZmiejszajacaPodatek;
    }
}
