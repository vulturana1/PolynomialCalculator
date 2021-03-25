package Model;

import java.util.ArrayList;
import java.util.List;

import View.View;

public class Model {

    public Model() {
        reset();
    }

    public void reset() {

    }

    public Polynomial addPolynomial(Polynomial P, Polynomial Q) {

        Polynomial R = new Polynomial();
        int i = 0;
        int j = 0;
        Monomial m;
        while (i < P.getNrMonoame() && j < Q.getNrMonoame()) {
            int coefP = (int) P.getPolynom().get(i).getCoefficient();
            int coefQ = (int) Q.getPolynom().get(j).getCoefficient();
            int powerP = P.getPolynom().get(i).getPower();
            int powerQ = Q.getPolynom().get(j).getPower();

            if (powerP == powerQ) {
                m = new Monomial(coefP + coefQ, powerP);
                i++;
                j++;
            } else if (powerP > powerQ) {
                m = new Monomial(coefP, powerP);
                i++;
            } else {
                m = new Monomial(coefQ, powerQ);
                j++;
            }
            R.addM(m);
        }
        while (i < P.getNrMonoame()) {
            int coefP = (int) P.getPolynom().get(i).getCoefficient();
            int powerP = P.getPolynom().get(i).getPower();
            m = new Monomial(coefP, powerP);
            i++;
            R.addM(m);
        }
        while (j < Q.getNrMonoame()) {
            int coefQ = (int) Q.getPolynom().get(j).getCoefficient();
            int powerQ = Q.getPolynom().get(j).getPower();
            m = new Monomial(coefQ, powerQ);
            j++;
            R.addM(m);
        }
        return R;
    }

    public Polynomial subPolynomial(Polynomial P, Polynomial Q) {
        Polynomial R = new Polynomial();
        int i = 0;
        int j = 0;
        Monomial m;
        while (i < P.getNrMonoame() && j < Q.getNrMonoame()) {
            int coefP = (int) P.getPolynom().get(i).getCoefficient();
            int coefQ = (int) Q.getPolynom().get(j).getCoefficient();
            int powerP = P.getPolynom().get(i).getPower();
            int powerQ = Q.getPolynom().get(j).getPower();

            if (powerP == powerQ) {
                m = new Monomial(coefP - coefQ, powerP);
                i++;
                j++;
            } else if (powerP > powerQ) {
                m = new Monomial(coefP, powerP);
                i++;
            } else {
                m = new Monomial(-coefQ, powerQ);
                j++;
            }
            R.addM(m);
        }
        while (i < P.getNrMonoame()) {
            int coefP = (int) P.getPolynom().get(i).getCoefficient();
            int powerP = P.getPolynom().get(i).getPower();
            m = new Monomial(coefP, powerP);
            i++;
            R.addM(m);
        }
        while (j < Q.getNrMonoame()) {
            int coefQ = (int) Q.getPolynom().get(j).getCoefficient();
            int powerQ = Q.getPolynom().get(j).getPower();
            m = new Monomial(-coefQ, powerQ);
            j++;
            R.addM(m);
        }
        return R;
    }

    public Polynomial mulPolynomial(Polynomial P, Polynomial Q) {
        Polynomial R = new Polynomial();

        for (Monomial mP : P.getPolynom()) {
            for (Monomial mQ : Q.getPolynom()) {
                int coef = (int) mP.getCoefficient() * (int) mQ.getCoefficient();
                int power = mP.getPower() + mQ.getPower();
                R.addM(new MonomialInt(coef, power));
            }
        }
        return R;
    }

    public String divPolynomial(Polynomial P, Polynomial Q) {

        String div = "";
        Polynomial R = new Polynomial();
        String rest = "";

        while (P.getPolynom().get(0).getPower() >= Q.getPolynom().get(0).getPower()) {
            int coeffQ = (int) Q.getPolynom().get(0).getCoefficient();
            int powerQ = Q.getPolynom().get(0).getPower();

            Monomial aux1 = new Monomial(coeffQ, powerQ);
            Monomial aux2 = P.getPolynom().get(0);

            int c1 = (int) aux2.getCoefficient();
            int c2 = (int) aux1.getCoefficient();
            int coeff = c1 / c2;

            MonomialInt imp = new MonomialInt(coeff, aux2.getPower() - aux1.getPower());
            R.addM(imp);
            Polynomial aux3 = new Polynomial();
            aux3.addM(imp);
            Polynomial pol = new Polynomial();
            pol = mulPolynomial(aux3,Q);
            P = subPolynomial(P,pol);

            rest = P.toString();

            P.getPolynom().remove(0);

            if (P.getPolynom().isEmpty())
                break;
        }

        if (P.getPolynom().isEmpty())
            rest = "0";
        div = R.toString() + "   r = " + rest;
        return div;
    }

    public Polynomial derivatePolynomial(Polynomial P) {
        int i = 0;
        Polynomial R = new Polynomial();
        for (Monomial m : P.getPolynom()) {
            int coef = (int) m.getCoefficient();
            int power = m.getPower();
            if (power != 0) {
                R.addM(new MonomialInt(coef * power, power - 1));
            }
        }
        return R;
    }

    public Polynomial integratePolynomial(Polynomial P) {
        Polynomial R = new Polynomial();
        for (Monomial m : P.getPolynom()) {
            int coef = (int) m.getCoefficient();
            int power = m.getPower();
            double coeff = (double) coef / (power + 1);
            R.addM(new MonomialDouble(coeff, power + 1));
        }
        return R;
    }
}

