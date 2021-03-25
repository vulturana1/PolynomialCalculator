package Controller;

import Model.Model;
import View.View;
import Model.Polynomial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        view.addAddListener(new AddListener());
        view.subAddListener(new SubListener());
        view.mulAddListener(new MulListener());
        view.divAddListener(new DivListener());
        view.derivateAddListener(new DerivateListener());
        view.integrateAddListener(new IntegrateListener());

    }

    class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String userInputP = "";
            String userInputQ = "";
            try {
                userInputP = view.getUserInputP();
                userInputQ = view.getUserInputQ();
                Polynomial P = new Polynomial();
                Polynomial Q = new Polynomial();
                P = P.toPolynomial(userInputP);
                Q = Q.toPolynomial(userInputQ);
                Polynomial R = model.addPolynomial(P, Q);
                view.setRez(R.toString());
            } catch (Exception ex) {
                view.showMessage("Format gresit");
            }
        }
    }

    class SubListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String userInputP = "";
            String userInputQ = "";
            try {
                userInputP = view.getUserInputP();
                userInputQ = view.getUserInputQ();
                Polynomial P = new Polynomial();
                Polynomial Q = new Polynomial();
                P = P.toPolynomial(userInputP);
                Q = Q.toPolynomial(userInputQ);
                Polynomial R = model.subPolynomial(P, Q);
                view.setRez(R.toString());
            } catch (Exception ex) {
                view.showMessage("Format gresit");
            }
        }
    }

    class MulListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String userInputP = "";
            String userInputQ = "";
            try {
                userInputP = view.getUserInputP();
                userInputQ = view.getUserInputQ();
                Polynomial P = new Polynomial();
                Polynomial Q = new Polynomial();
                P = P.toPolynomial(userInputP);
                Q = Q.toPolynomial(userInputQ);
                Polynomial R = model.mulPolynomial(P, Q);
                view.setRez(R.toString());
            } catch (Exception ex) {
                view.showMessage("Format gresit");
            }
        }
    }

    class DivListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String userInputP = "";
            String userInputQ = "";
            try {
                userInputP = view.getUserInputP();
                userInputQ = view.getUserInputQ();
                Polynomial P = new Polynomial();
                Polynomial Q = new Polynomial();
                P = P.toPolynomial(userInputP);
                Q = Q.toPolynomial(userInputQ);
                String R = model.divPolynomial(P, Q);
                view.setRez(R);
            } catch (Exception ex) {
                view.showMessage("Format gresit");
            }
        }
    }

    class DerivateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String userInputP = "";
            try {
                userInputP = view.getUserInputP();
                Polynomial P = new Polynomial();
                P = P.toPolynomial(userInputP);
                Polynomial R = model.derivatePolynomial(P);
                view.setRez(R.toString());
            } catch (Exception ex) {
                view.showMessage("Format gresit");
            }
        }
    }

    class IntegrateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String userInputP = "";
            try {
                userInputP = view.getUserInputP();
                Polynomial P = new Polynomial();
                P = P.toPolynomial(userInputP);
                Polynomial R = model.integratePolynomial(P);
                view.setRez(R.toStringDouble());
            } catch (Exception ex) {
                view.showMessage("Format gresit");
            }
        }
    }
}
