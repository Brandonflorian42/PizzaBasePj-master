package edu.formularios;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class frmPizza {
    private JPanel jpanelPrincipal;
    private JComboBox comboBoxToppings;
    private JTextField txtPizza;
    private JButton bntAddIngrediente;
    private JLabel lblTotal;
    private JList lista1;
    private JButton btnPreparar;

    private DefaultListModel modeLista = new DefaultListModel();

    private double total = 0;

    private List<Topping> ingredientes = new ArrayList<>();

    public JPanel getJpanelPrincipal() {
        return jpanelPrincipal;
    }

    public frmPizza() {
        cargarToppings();

        bntAddIngrediente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Topping ingrediente = (Topping) comboBoxToppings.getSelectedItem();

                modeLista.addElement(ingrediente.toString());
                lista1.setModel (modeLista);
                total  += ingrediente.getPrecio();
                lblTotal.setText(String.valueOf(total));



            }
        });
        btnPreparar.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                Pizza pizza = new Pizza(txtPizza.getText());
                Topping topi;
                for (int i=0; i < lista1.getModel().getSize();i++)
                {
                    topi = (Topping) lista1.getModel().getElementAt(i);
                    pizza.addTopping(topi);
                }



            }
        });
    }




    private void cargarToppings(){
        ingredientes.add(new Topping("chapiñones",4.55));
        ingredientes.add(new Topping("Tomates",2.55));
        ingredientes.add(new Topping("Cebolla",6.55));
        ingredientes.add(new Topping("Salchica",10.55));
        ingredientes.add(new Topping("Calamares",11.55));
        ingredientes.add(new Topping("Chucho",14.55));

        DefaultComboBoxModel model = new DefaultComboBoxModel(ingredientes.toArray());
        comboBoxToppings.setModel(model);


    }


}
