/**
 * Represents a laptop electronic item.
 *
 * <p>Extends the electronic class by adding the laptop's
 * screen size specification.</p>
 */
public class laptop extends electronic {

    private Double screenSize;

    /**
     * Creates a laptop with the specified identification,
     * electronic number, price, and screen size.
     *
     * @param eID unique electronic identifier
     * @param electronicNum electronic item number
     * @param price price of the laptop
     * @param screenSize laptop screen size in inches
     */
    public laptop(
            String eID,
            int electronicNum,
            double price,
            Double screenSize) {

        super(eID, electronicNum, price);
        this.screenSize = screenSize;
    }

    /**
     * Gets the laptop's screen size.
     *
     * @return screen size in inches
     */
    public Double getScreenSize() {
        return screenSize;
    }

    /**
     * Sets the laptop's screen size.
     *
     * @param screenSize new screen size in inches
     */
    public void setScreenSize(Double screenSize) {
        this.screenSize = screenSize;
    }

    /**
     * Returns a string representation of the laptop.
     *
     * @return electronic information followed by screen size
     */
    @Override
    public String toString() {
        return super.toString() + "\t" + screenSize;
    }

    /**
     * Compares this laptop with another laptop based on
     * inherited electronic information and screen size.
     *
     * @param l laptop to compare with
     * @return true if both laptops contain the same information
     */
    public boolean equals(laptop l) {
        return super.equals(l) && screenSize.equals(l.screenSize);
    }
}