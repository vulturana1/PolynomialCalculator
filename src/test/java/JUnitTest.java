import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import Model.Model;
import Model.Monomial;
import Model.Polynomial;
import Model.MonomialDouble;

import org.junit.Test;

public class JUnitTest {

    Polynomial polynomial = new Polynomial() ;
    Monomial monomial = new Monomial();

    String p1 = "12x^4-6x^3+2x^1+7";
    String p2 = "3x^2+2";

    Model model = new Model();

    @Test
    public void addPolynomial() throws Exception {

        Polynomial pol1 = new Polynomial();
        pol1 = pol1.toPolynomial(p1);

        Polynomial pol2 = new Polynomial();
        pol2 = pol2.toPolynomial(p2);

        String rez = "12x^4-6x^3+3x^2+2x+9";

        Polynomial p = new Polynomial();
        p = model.addPolynomial(pol1, pol2);
        String rez1 = p.toString();

        assertEquals(rez, rez1);
    }

    @Test
    public void subPolynomial() throws Exception {
        Polynomial pol1 = new Polynomial();
        pol1 = pol1.toPolynomial(p1);

        Polynomial pol2 = new Polynomial();
        pol2 = pol2.toPolynomial(p2);

        String rez = "12x^4-6x^3-3x^2+2x+5";

        Polynomial p = new Polynomial();
        p = model.subPolynomial(pol1, pol2);
        String rez1 = p.toString();

        assertEquals(rez, rez1);
    }

    @Test
    public void mulPolynomial() throws Exception {
        Polynomial pol1 = new Polynomial();
        pol1 = pol1.toPolynomial(p1);

        Polynomial pol2 = new Polynomial();
        pol2 = pol2.toPolynomial(p2);

        String rez = "36x^6+24x^4-18x^5-12x^3+6x^3+4x+21x^2+14";

        Polynomial p = new Polynomial();
        p = model.mulPolynomial(pol1, pol2);
        String rez1 = p.toString();

        assertEquals(rez, rez1);
    }

    @Test
    public void divPolynomial() throws Exception {
        Polynomial pol1 = new Polynomial();
        pol1 = pol1.toPolynomial(p1);

        Polynomial pol2 = new Polynomial();
        pol2 = pol2.toPolynomial(p2);

        String rez = "4x^2-2x-2   r = -2x^2+6x+11";

        String rez1 = model.divPolynomial(pol1, pol2);

        assertEquals(rez, rez1);
    }

    @Test
    public void derivatePolynomial() throws Exception {
        Polynomial pol1 = new Polynomial();
        pol1 = pol1.toPolynomial(p1);

        String rez = "48x^3-18x^2+2";

        Polynomial p = new Polynomial();
        p = model.derivatePolynomial(pol1);
        String rez1 = p.toString();

        assertEquals(rez, rez1);
    }

    @Test
    public void integratePolynomial() throws Exception {
        Polynomial pol1 = new Polynomial();
        pol1 = pol1.toPolynomial(p1);

        String rez = "2.40x^5-1.50x^4+x^2+7.00x";

        Polynomial p = new Polynomial();
        p = model.integratePolynomial(pol1);
        String rez1 = p.toStringDouble();

        assertEquals(rez, rez1);
    }
}