import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class ProGUI2 {

    private JButton addNewProductButton;
    private JButton viewAllProductButton;
    private JButton searchForProductButton;
    private JPanel allCards;
    private JPanel c1;
    private JPanel c2;
    private JPanel c3;
    private JTextField pID;
    private JTextField pName;
    private JTextField pPrice;
    private JTextField pDate;
    private JPanel mainPanel;
    private JTextArea allProductData;
    private JTextField id;
    private JTextArea searchedData;
    private JButton searchButton;
    private JButton saveToFileButton;
    private JButton editButton;
    private JButton deleteButton;
    private JPanel c4;
    private JTextField idToEdit;
    private JTextField newDate;
    private JTextField newName;
    private JTextField newPrice;
    private JTextField newID;
    private JButton editButton1;
    private JPanel c5;
    private JTextField idToDelete;
    private JButton deleteProductButton;
    private JLabel productNumber;
    Controller c;
    public ProGUI2 () throws FileNotFoundException {
        Controller c= new Controller();
        productNumber.setText("NUMBER OF PRODUCTS"+ Products.counter);
        addNewProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allCards.removeAll();
                allCards.add(c1);
                allCards.repaint();
                allCards.revalidate();
                if(!pID.getText().equals("")&&!pName.getText().equals("")&&!pPrice.getText().equals("")
                &&!pDate.getText().equals("")){
                    int i=Integer.parseInt(pID.getText());
                    String n=pName.getText();
                    double p= Double.parseDouble(pPrice.getText());
                    String d=pDate.getText();

                    boolean added=c.addNewProduct(i,n,p,d);
                    if (added){
                        JOptionPane.showMessageDialog(null,"ADDED SUCCESSFULLY");
                        pID.setText("");
                        pName.setText("");
                        pPrice.setText("");
                        pDate.setText("");
                        productNumber.setText("NUMBER OF PRODUCTS"+ Products.counter);
                    }
                    else JOptionPane.showMessageDialog(null,"ADDITION FAILED");
                }
            }
        });

        viewAllProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Products[] all=c.viewAllProducts();
                allProductData.setText("ID\tNAME\tPRICE\tDATE");
                for (int i=0; i<c.numOfProducts; i++){
                    allProductData.setText(allProductData.getText()+"\n"+all[i].getId()+"\t"
                            +all[i].getName()+"\t"+all[i].getPrice()+"\t"+all[i].getDate());
                }
                allCards.removeAll();
                allCards.add(c2);
                allCards.repaint();
                allCards.revalidate();

            }
        });


        searchForProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allCards.removeAll();
                allCards.add(c3);
                allCards.repaint();
                allCards.revalidate();
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!id.getText().equals("")) {
                    int i=Integer.parseInt(id.getText());
                    Products p= c.searchForProduct(i);
                    if(p!=null) {
                        searchedData.setText(p.getId()+" "+p.getName()+" "
                                +p.getPrice()+" "+p.getDate());
                    }
                    else searchedData.setText("NOT FOUND");
                }
            }
        });

        saveToFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    c.writeProductFile();
                    JOptionPane.showMessageDialog(null,"DATA WAS SAVED SUCCESSFULLY");
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null,"SOMETHING WENT WRONG");
                }
            }
        });

        editButton1.addActionListener(new ActionListener() {
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

        deleteProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i=Integer.parseInt(idToDelete.getText());
                Products deleteProduct=c.searchForProduct(i);
                if(deleteProduct!=null) {

                    int confirm= JOptionPane.showConfirmDialog(null,"ARE YOU SURE TO DELETE THE FOLLOWING " +
                            "PRODUCT\n" + deleteProduct.print()+"?");
                    if(confirm==0) {
                        boolean delete=c.DeleteProduct(i);
                        if(delete)  JOptionPane.showMessageDialog(null,"DELETED SUCCESSFULLY") ;
                        else  JOptionPane.showMessageDialog(null,"FAILED TO DELETE");

                    }
                    else  JOptionPane.showMessageDialog(null,"SORRY THERE IS NO PRODUCT WITH THIS ID"
                    + idToDelete.getText()+"");

                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allCards.removeAll();
                allCards.add(c5);
                allCards.repaint();
                allCards.revalidate();
            }
        });
    }


     public static void main(String[]args) throws FileNotFoundException{
        JFrame frame=new JFrame("CANDLE DISTRIBUTION CENTER");
        frame.setLocation(500,300);
        frame.setSize(1000,600);
        frame.setContentPane(new ProGUI2().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


     }

}
