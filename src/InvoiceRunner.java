public class InvoiceRunner {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    private static void createAndShowGUI() {
        InvoiceFrame invoiceFrame = new InvoiceFrame();
        invoiceFrame.setVisible(true);
    }
}