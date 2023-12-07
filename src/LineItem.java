public class LineItem {
    private Product product;
    private int quantity;

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotal() {
        return quantity * product.getUnitPrice();
    }

    public String displayLineItem() {
        return String.format("%s,    $%.2f,    %d,    $%.2f%n",
                product.getName(), product.getUnitPrice(), quantity, getTotal());
    }

}

