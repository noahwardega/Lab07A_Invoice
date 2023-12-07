import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InvoiceFrame extends JFrame {

    private JTextField titleField;
    private JTextField customerAddrField;
    private JTextField productNameField;
    private JTextField unitPriceField;
    private JTextField quantityField;
    private JTextArea displayArea;

    private Invoice invoice;
    private List<LineItem> lineItems;

    public InvoiceFrame() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Invoice Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        titleField = new JTextField(20);
        customerAddrField = new JTextField(20);
        productNameField = new JTextField(20);
        unitPriceField = new JTextField(10);
        quantityField = new JTextField(5);
        displayArea = new JTextArea(10, 30);

        JButton addButton = new JButton("Add Line Item");
        JButton displayButton = new JButton("Display Invoice");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addLineItem();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayInvoice();
            }
        });

        add(new JLabel("Invoice Title:"));
        add(titleField);
        add(new JLabel("Customer Address:"));
        add(customerAddrField);
        add(new JLabel("Product Name:"));
        add(productNameField);
        add(new JLabel("Unit Price:"));
        add(unitPriceField);
        add(new JLabel("Quantity:"));
        add(quantityField);
        add(addButton);
        add(displayButton);
        add(new JScrollPane(displayArea));

        invoice = new Invoice();
        lineItems = new ArrayList<>();
    }

    private void addLineItem() {
        String productName = productNameField.getText();
        double unitPrice = Double.parseDouble(unitPriceField.getText());
        int quantity = Integer.parseInt(quantityField.getText());

        Product product = new Product(productName, unitPrice);
        LineItem lineItem = new LineItem(product, quantity);

        lineItems.add(lineItem);
        productNameField.setText("");
        unitPriceField.setText("");
        quantityField.setText("");
    }

    private void displayInvoice() {
        invoice.setTitle(titleField.getText());
        invoice.setCustomerAddr(customerAddrField.getText());
        invoice.setLineItems(lineItems);

        displayArea.setText(invoice.displayInvoice());
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InvoiceFrame().setVisible(true);
            }
        });
    }
}

