package View;

import Model.Model;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private JPanel contentPane;
    private JTextField userInputP;
    private JTextField userInputQ;
    private JTextField textField_Rez;
    JButton addBtn = new JButton("+");
    JButton subBtn = new JButton("-");
    JButton mulBtn = new JButton("*");
    JButton divBtn = new JButton("/");
    JButton derivateBtn = new JButton("P'");
    JButton integrateBtn = new JButton("∫Pdx");
    JButton reset = new JButton("Reset");
    Model model;

    public View(Model model) {
        this.setTitle("Polynomial Calculator");
        this.model = model;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 180);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JLabel lblNewLabel = new JLabel("Polinom P: ");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);

        userInputP = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 0);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 0;
        contentPane.add(userInputP, gbc_textField);
        userInputP.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Polinom Q: ");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 1;
        contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

        userInputQ = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.insets = new Insets(0, 0, 5, 0);
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 1;
        gbc_textField_1.gridy = 1;
        contentPane.add(userInputQ, gbc_textField_1);
        userInputQ.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Rezultat: ");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 2;
        contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

        textField_Rez = new JTextField();
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.insets = new Insets(0, 0, 5, 0);
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.gridx = 1;
        gbc_textField_2.gridy = 2;
        contentPane.add(textField_Rez, gbc_textField_2);
        textField_Rez.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Operatii: ");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_3.gridx = 0;
        gbc_lblNewLabel_3.gridy = 3;
        contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);


        GridBagConstraints gbc_reset = new GridBagConstraints();
        gbc_reset.insets = new Insets(0, 0, 0, 5);
        gbc_reset.gridx = 0;
        gbc_reset.gridy = 4;
        contentPane.add(reset, gbc_reset);

        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 1;
        gbc_panel.gridy = 3;
        contentPane.add(panel, gbc_panel);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel info = new JLabel("Format polinom: ax^n+bx^n-1+cx^n-2+...+dx^1+e");
        GridBagConstraints gbc_info = new GridBagConstraints();
        gbc_info.gridx = 1;
        gbc_info.gridy = 4;
        contentPane.add(info, gbc_info);

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInputP.setText("");
                textField_Rez.setText("");
                userInputQ.setText("");
            }
        });

        panel.add(addBtn);
        panel.add(subBtn);
        panel.add(mulBtn);
        panel.add(divBtn);
        panel.add(derivateBtn);
        panel.add(integrateBtn);
    }

    public String getUserInputP() {
        return userInputP.getText();
    }

    public String getUserInputQ() {
        return userInputQ.getText();
    }

    public void setRez(String newTotal) {
        textField_Rez.setText(newTotal);
    }

    public void addAddListener(ActionListener mal) {
        addBtn.addActionListener(mal);
    }

    public void subAddListener(ActionListener mal) {
        subBtn.addActionListener(mal);
    }

    public void mulAddListener(ActionListener mal) {
        mulBtn.addActionListener(mal);
    }

    public void divAddListener(ActionListener mal) {
        divBtn.addActionListener(mal);
    }

    public void derivateAddListener(ActionListener mal) {
        derivateBtn.addActionListener(mal);
    }

    public void integrateAddListener(ActionListener mal) {
        integrateBtn.addActionListener(mal);
    }

    public void showMessage(String s) {
        JOptionPane.showMessageDialog(null, s, "Eroare", JOptionPane.ERROR_MESSAGE);
    }
}
