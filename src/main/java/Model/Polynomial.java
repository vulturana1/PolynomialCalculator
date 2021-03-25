package Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.*;

public class Polynomial {

    List<Monomial> args = new ArrayList<Monomial>();
    private int nrMonoame = 0;

    public void addM(Monomial m) {
        args.add(m);
        nrMonoame++;
    }

    void removeM(int i) {
        args.remove(i);
        nrMonoame--;
    }

    public void reset() {
        args.clear();
        nrMonoame = 0;
    }

    public int getNrMonoame() {
        return args.size();
    }

    public void setNrMonoame(int nrMonoame) {
        this.nrMonoame = nrMonoame;
    }

    public List<Monomial> getPolynom() {
        return args;
    }

    public void setPolynomial(List<Monomial> polynomial) {
        this.args = polynomial;
    }

    public String toString() {
        String PolynomialString = "";
        String auxP = "";
        String auxC = "";
        boolean areMonomPozitiv = false;

        for (Monomial m : this.args) {
            int coeff = (int) m.getCoefficient();
            if (coeff == 0)
                continue;
            if ((coeff != 1) && (coeff != -1))
                auxC = coeff + "";
            else if (coeff == 1) {
                auxC = "";
                areMonomPozitiv = true;
            } else {
                auxC = "-";
            }
            if ((m.getPower() != 0) && (m.getPower() != 1))
                auxP = "x^" + (int) m.getPower();
            else
            if (m.getPower() == 1)
                auxP = "x";
            else
                auxP = "";
            if (coeff == 1 && m.getPower() == 0)
                auxC = "1";
            if (coeff == -1 && m.getPower() == 0)
                auxC = "-1";

            PolynomialString = PolynomialString + auxC + auxP + "+";
            PolynomialString = PolynomialString.replace("+-", "-");
        }
        if (PolynomialString.compareTo("") == 0) {
            if (areMonomPozitiv)
                PolynomialString = "1";
            else
                PolynomialString = "0";
        } else if (PolynomialString.length() > 0)
            PolynomialString = PolynomialString.substring(0, PolynomialString.length() - 1);
        PolynomialString = PolynomialString.replace("+-", "-");
        if (PolynomialString.compareTo("-") == 0)
            PolynomialString = "-1";
        if (args.isEmpty()) {
            PolynomialString = "0";
        }
        return PolynomialString;
    }

    public String toStringDouble() {
        String PolynomialString = "";
        String auxP = "";
        String auxC = "";
        boolean areMonomPozitiv = false;

        for (Monomial m : this.args) {
            double coeff = (double) m.getCoefficient();
            if (coeff == 0.0)
                continue;
            if ((coeff != 1.0) && (coeff != -1.0))
                //auxC = coeff + "";
                auxC = String.format("%.2f", coeff);
            else if (coeff == 1.0) {
                auxC = "";
                areMonomPozitiv = true;
            } else {
                auxC = "-";
            }
            if ((m.getPower() != 0) && (m.getPower() != 1))
                auxP = "x^" + (int) m.getPower();
            else
            if (m.getPower() == 1)
                auxP = "x";
            else
                auxP = "";
            if (coeff == 1.0 && m.getPower() == 0)
                auxC = "1";
            if (coeff == -1.0 && m.getPower() == 0)
                auxC = "-1";

            PolynomialString = PolynomialString + auxC + auxP + "+";
            PolynomialString = PolynomialString.replace("+-", "-");
        }
        if (PolynomialString.compareTo("") == 0) {
            if (areMonomPozitiv)
                PolynomialString = "1";
            else
                PolynomialString = "0";
        } else if (PolynomialString.length() > 0)
            PolynomialString = PolynomialString.substring(0, PolynomialString.length() - 1);
        PolynomialString = PolynomialString.replace("+-", "-");
        if (PolynomialString.compareTo("-") == 0)
            PolynomialString = "-1";
        if (args.isEmpty()) {
            PolynomialString = "0";
        }
        return PolynomialString;
    }

    public Polynomial toPolynomial(String p) throws Exception {

        Pattern pattern = Pattern.compile("(\\+|-)?(\\d+x|\\d+)(\\^\\d+)?");

        Matcher matcher = pattern.matcher(p);

        boolean hasCoef = false;
        boolean negative = false;//
        int coeffMonom = 0;
        int powerMonom = 0;
        if (matcher.find()) {
            if(p.startsWith("-")) {
                hasCoef = true;
                negative = true;
            }
            if(p.startsWith("x")) {
                hasCoef = true;
                negative = false;
            }
            if(hasCoef == true) {
                if(negative == true) {
                    coeffMonom = -1;
                    p = p.substring(1);
                }
                if(negative == false)
                    coeffMonom = 1;
            }

            Polynomial polynomial = new Polynomial();

            String inter = "";
            StringTokenizer s1 = new StringTokenizer(p, "x^");

            while (s1.hasMoreElements()) {

                inter = (String) s1.nextElement();

                StringTokenizer s2 = new StringTokenizer(inter, "+");
                StringTokenizer s3 = new StringTokenizer(inter, "-");

                if (inter.indexOf("-") != -1)
                    while (s3.hasMoreElements()) {
                        if (coeffMonom == 0) {
                            String copy = (String) s3.nextElement();
                            coeffMonom = Integer.parseInt(copy);
                            coeffMonom = -coeffMonom;
                            continue;
                        } else if (powerMonom == 0) {
                            String copy = (String) s3.nextElement();
                            powerMonom = Integer.parseInt(copy);
                            continue;
                        }

                        Monomial monom = new Monomial(coeffMonom, powerMonom);
                        polynomial.addM(monom);
                        powerMonom = 0;
                        coeffMonom = 0;
                    }
                else
                    while (s2.hasMoreElements()) {
                        if (coeffMonom == 0) {
                            String value = (String) s2.nextElement();
                            coeffMonom = Integer.parseInt(value);
                            continue;
                        } else if (powerMonom == 0) {
                            String value = (String) s2.nextElement();
                            powerMonom = Integer.parseInt(value);
                            continue;
                        }

                        Monomial monom = new Monomial(coeffMonom, powerMonom);
                        polynomial.addM(monom);

                        powerMonom = 0;
                        coeffMonom = 0;
                    }
            }
            if (coeffMonom != 0) {
                Monomial monom = new Monomial(coeffMonom, powerMonom);
                polynomial.addM(monom);
            }
            return polynomial;
        } else {
            throw new Exception("Format gresit");
        }
    }

}
