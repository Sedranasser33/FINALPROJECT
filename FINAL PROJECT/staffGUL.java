import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class staffGUL {
    Controller c;
    private JButton ADDButton;
    private JButton SEARCHButton;
    private JButton VIEWButton;
    private JButton EXITButton;
    private JButton DELETEButton;
    private JPanel c1;
    private JPanel c2;
    private JPanel c3;
    private JPanel c4;
    private JPanel c5;
    private JPanel allCards;
    private JTextField idToAdd;
    private JTextField nameToAdd;
    private JTextField salaryToAdd;
    private JTextField addressYoAdd;
    private JButton ADDSTAFFButton;
    private JTextField phoneToAdd;
    private JLabel inputId;
    private JLabel inputName;
    private JLabel inputSalary;
    private JLabel inputAddress;
    private JLabel inoutPhone;
    private JButton SAVETOFILEButton;
    private JPanel mainPanel;
    private JTextArea viewArea;
    private JTextField idToDelete;
    private JButton DELETESTAFButton;
    private JTextField idToSearch;
    private JButton SEARCHFORSTAFFButton;
    private JLabel idAdd;
    private JButton VIEWSTAFFButton;

    public staffGUL() throws FileNotFoundException {

        c=new Controller();
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allCards.removeAll();
                allCards.add(c1);
                allCards.repaint();
                allCards.revalidate();
            }
        });
        ADDSTAFFButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                int i;
//                String n;
//                double p;
//                String d;
                try {
                   int i = Integer.parseInt(idToAdd.getText());
                   String  n = nameToAdd.getText();
                   double s = Double.parseDouble(salaryToAdd.getText());
                    String a = addressYoAdd.getText();
                    int p= Integer.parseInt(phoneToAdd.getText());

                    boolean added = c.addNewStaff(i,n,s,a,p);
                    if (added) {
                        JOptionPane.showMessageDialog(null, "ADDED SUCCESSFULLY");
                        idToAdd.setText("");
                        nameToAdd.setText("");
                        addressYoAdd.setText("");
                        phoneToAdd.setText("");
                        salaryToAdd.setText("");
                        // boolean add= c.checkForDuplicate();
                    } else {
                        JOptionPane.showMessageDialog(null, "ADDITION FAILED");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, " ERROR DURING PARSE");
                }

            }

        });
//        SAVETOFILEButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    c.writeStaffFile();
//                    JOptionPane.showMessageDialog(null, "DATA WAS SAVED TO FILE SUCCESSFULLY");
//                } catch (FileNotFoundException ex) {
//                    JOptionPane.showMessageDialog(null, "SOMETHING WENT WRONG");
//                }
//            }

        VIEWButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allCards.removeAll();
                allCards.add(c2);
                allCards.repaint();
                allCards.revalidate();

                String s = "ID\tNAME\tADDRESS\tPHONE NUMBER\tSALARY";
                Staff[] all = c.viewAllStaff();
                for (Staff x : all) {

                    if (x != null)
                        s = s + x.toString();

                }
                viewArea.setText(s);

            }
        });
//        DELETEButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                allCards.removeAll();
//                allCards.add(c3);
//                allCards.repaint();
//                allCards.revalidate();
//            }
//        });
//        DELETESTAFButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    int i = Integer.parseInt(idToDelete.getText());
//                    Staff deleteStaff= c.searchForStaff(i);
//                    if (deleteStaff != null) {
//
//                        int confirm = JOptionPane.showConfirmDialog(null, "ARE YOU SURE TO DELETE THE FOLLOWING " +
//                                "PRODUCT\n" + deleteStaff.print() + "?");
//                        if (confirm == 0) {
//                            boolean delete = c.DeleteProduct(i);
//                            if (delete) {JOptionPane.showMessageDialog(null, "DELETED SUCCESSFULLY");
//                                idToDelete.setText("");}
//                            else JOptionPane.showMessageDialog(null, "FAILED TO DELETE");
//                            idToDelete.setText("");
//
//                        }
//                    }else JOptionPane.showMessageDialog(null,"SORRY THERE IS NO PRODUCT WITH THIS ID");
//                    idToDelete.setText("");
//                }catch (Exception ex) {
//                    JOptionPane.showMessageDialog(null, ""
//                            + idToDelete.getText() + " IS NOT A VALID SELECTION"); idToDelete.setText("");
//                }
//            }
//        });
//

        SEARCHButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                allCards.removeAll();
                allCards.add(c4);
                allCards.repaint();
                allCards.revalidate();

            }
        });
        SEARCHFORSTAFFButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!idAdd.getText().equals("")) {
                    int i = Integer.parseInt(idAdd.getText());
                    Products p = c.searchForProduct(i);
                    if (p != null) {
                        idToSearch.setText(p.getId() + " " + p.getName() + " "
                                + p.getPrice() + " " + p.getDate());
                    } else JOptionPane.showMessageDialog(null, "NOT FOUND");
                    idAdd.setText("");
                }
            }
        });
        EXITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allCards.removeAll();
                allCards.add(c5);
                allCards.repaint();
                allCards.revalidate();
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) throws FileNotFoundException {
        JFrame frame = new JFrame("STAFF DATA");
        frame.setContentPane(new staffGUL().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setLocation(400,200);
        frame.setSize(500, 300);
        frame.setVisible(true);
    }
}
