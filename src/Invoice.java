import java.util.List;

public class Invoice {
    private String title;
    private String customerAddr;
    private List<LineItem> lineItems;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCustomerAddr(String customerAddr) {
        this.customerAddr = customerAddr;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public String displayInvoice() {
        StringBuilder invoiceText = new StringBuilder();
        invoiceText.append("Invoice\n");
        invoiceText.append("Address: ").append(customerAddr).append("\n");
        invoiceText.append("-------------------------------------------------------\n");
        invoiceText.append(String.format("%-20s %-10s %-10s %-10s\n", "Item", "Qty", "Price", "Total"));
        invoiceText.append("-------------------------------------------------------\n");

        double totalAmountDue = 0.0;

        for (LineItem lineItem : lineItems) {
            invoiceText.append(lineItem.displayLineItem()).append("\n");
            totalAmountDue += lineItem.getTotal();
        }

        invoiceText.append("-------------------------------------------------------\n");
        invoiceText.append(String.format("%-40s $%.2f", "Amount Due:", totalAmountDue));

        return invoiceText.toString();
    }
}



