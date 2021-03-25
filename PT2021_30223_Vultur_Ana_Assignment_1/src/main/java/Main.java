import Controller.Controller;
import Model.Model;
import View.View;

public class Main {
    public static void main(String[] args){
        Model m = new Model();
        View v = new View(m);
        Controller c = new Controller(m, v);
        v.setVisible(true);
    }
}
