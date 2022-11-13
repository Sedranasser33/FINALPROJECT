import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class ProductsGUI {

    Controller c;
    private JPanel mainPanel;
    private JButton DELETEButton;
    private JButton MODIFYButton;
    private JButton VIEWButton;
    private JButton SEARCHButton;
    private JButton ADDButton;
    private JButton EXITButton;
    private JPanel allCards;
    private JPanel c1;
    private JPanel c2;
    private JPanel c3;
    private JPanel c4;
    private JPanel c5;
    private JPanel c6;
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private JButton saveToFileButton;
    private JTextArea textArea1;
    private JLabel idToSearch;
    private JTextField id;
    private JTextArea searchData;
    private JButton searchForProduct;
    private JLabel editId;
    private JTextField idToEdit;
    private JButton editButton;
    private JTextField newName;
    private JTextField newPrice;
    private JTextField newDate;
    private JLabel newIdToEdit;
    private JTextField newID;
    private JLabel newNameToEdit;
    private JLabel newPriceToEdit;
    private JLabel newDateToEdit;
    private JTextField idToDelete;
    private JButton CLEARButton;
    private JLabel IDLabel;
    private JLabel PRICELabel;
    private JLabel NAMELabel;
    private JLabel DATELabel   ;
    private JLabel idDelete;
    private JButton addButton1;


    public ProductsGUI() throws FileNotFoundException {

        c = new Controller();
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allCards.removeAll();
                allCards.add(c1);
                allCards.repaint();
                allCards.revalidate();
            }
        });
        MODIFYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                allCards.removeAll();
                allCards.add(c2);
                allCards.repaint();
                allCards.revalidate();

            }
        });
        SEARCHButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allCards.removeAll();
                allCards.add(c3);
                allCards.repaint();
                allCards.revalidate();
            }
        });


        VIEWButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allCards.removeAll();
                allCards.add(c4);
                allCards.repaint();
                allCards.revalidate();

                String s = "ID\tNAME\tPRICE\tDATE";
                Products[] all = c.viewAllProducts();
                for (Products x : all) {

                    if (x != null)
                        s = s + x.toString();

                }
                textArea1.setText(s);
            }
        });
        DELETEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allCards.removeAll();
                allCards.add(c5);
                allCards.repaint();
                allCards.revalidate();
            }
        });
        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allCards.removeAll();
                allCards.add(c6);
                allCards.repaint();
                allCards.revalidate();
                System.exit(0);

            }
        });
        saveToFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    c.writeProductFile();
                    JOptionPane.showMessageDialog(null, "DATA WAS SAVED TO FILE SUCCESSFULLY");
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "SOMETHING WENT WRONG");
                }
            }


        });

        searchForProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!id.getText().equals("")) {
                    int i=Integer.parseInt(id.getText());
                    Products p= c.searchForProduct(i);
                    if(p!=null) {
                        searchData.setText(p.getId()+" "+p.getName()+" "
                                +p.getPrice()+" "+p.getDate());
                    }
                    else JOptionPane.showMessageDialog(null,"NOT FOUND") ;
                    id.setText("");
                }
            }


        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!idToEdit.getText().equals("")){
                    int i=Integer.parseInt(idToEdit.getText());
                    int nID=Integer.parseInt(newID.getText());
                    String nName=newName.getText();
                    double nPrice= Double.parseDouble(newPrice.getText());
                    String nDate= newDate.getText();
                    boolean edited=c.editProductData(i,nID,nName,nPrice,nDate);
                    if(edited) {
                        JOptionPane.showMessageDialog(null,"UPDATED SUCCESSFULLY") ;
                        idToEdit.setText("");
                        newID.setText("");
                        newName.setText("");
                        newPrice.setText("");
                        newDate.setText("");
                    }
                    JOptionPane.showMessageDialog(null,"NO PRODUCT WITH THIS ID"+ idToEdit+"");
                }
            }

        });
        CLEARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int i = Integer.parseInt(idToDelete.getText());
                    Products deleteProduct = c.searchForProduct(i);
                    if (deleteProduct != null) {

                        int confirm = JOptionPane.showConfirmDialog(null, "ARE YOU SURE TO DELETE THE FOLLOWING " +
                                "PRODUCT\n" + deleteProduct.print() + "?");
                        if (confirm == 0) {
                            boolean delete = c.DeleteProduct(i);
                            if (delete) {JOptionPane.showMessageDialog(null, "DELETED SUCCESSFULLY");
                            idToDelete.setText("");}
                            else JOptionPane.showMessageDialog(null, "FAILED TO DELETE");
                            idToDelete.setText("");

                        }
                    }else JOptionPane.showMessageDialog(null,"SORRY THERE IS NO PRODUCT WITH THIS ID");
                    idToDelete.setText("");
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ""
                            + idToDelete.getText() + " IS NOT A VALID SELECTION"); idToDelete.setText("");
                }
            }

             });



        addButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i;
                String n;
                double p;
                String d;
                try {
                    i = Integer.parseInt(t1.getText());
                    n = t2.getText();
                    p = Double.parseDouble(t3.getText());
                    d = t4.getText();
                    boolean added = c.addNewProduct(i,n,p,d);

                    if (added) {
                        JOptionPane.showMessageDialog(null, "ADDED SUCCESSFULLY");
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                       // boolean add= c.checkForDuplicate();
                    } else {
                        JOptionPane.showMessageDialog(null, "ADDITION FAILED");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, " ERROR DURING PARSE");
                }

            }
        });
    }

    public static void main(String[] args) throws FileNotFoundException {
        JFrame frame = new JFrame("PRODUCT DATA\n");
        frame.setContentPane(new ProductsGUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setLocation(400,200);
        frame.setSize(500, 300);
        frame.setVisible(true);
    }
}