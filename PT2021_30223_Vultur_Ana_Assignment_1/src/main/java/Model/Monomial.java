package Model;

public class Monomial<E>{

    private int power;
    private E coefficient;

    public Monomial(){

    }

    public Monomial(E coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public E getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(E coefficient) {
        this.coefficient = coefficient;
    }

}
