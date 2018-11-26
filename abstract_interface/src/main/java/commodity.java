public abstract class commodity {
    private int Quantity = 0;

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public abstract void minusQuantity();

    public abstract void plusQuantity();
}
