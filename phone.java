/**
 * Represents a phone electronic item.
 *
 * <p>Extends the electronic class by adding whether the phone
 * supports 5G connectivity.</p>
 */
public class phone extends electronic {

    private Boolean has5G;

    /**
     * Creates a phone with the specified identification,
     * electronic number, price, and 5G capability.
     *
     * @param eID unique electronic identifier
     * @param electronicNum electronic item number
     * @param price price of the phone
     * @param has5G indicates whether the phone supports 5G
     */
    public phone(
            String eID,
            int electronicNum,
            double price,
            Boolean has5G) {

        super(eID, electronicNum, price);
        this.has5G = has5G;
    }

    /**
     * Gets whether the phone supports 5G.
     *
     * @return true if the phone supports 5G; false otherwise
     */
    public Boolean getHas5G() {
        return has5G;
    }

    /**
     * Sets the phone's 5G capability.
     *
     * @param has5G new 5G capability
     */
    public void setHas5G(Boolean has5G) {
        this.has5G = has5G;
    }

    /**
     * Returns a string representation of the phone.
     *
     * @return electronic information followed by 5G capability
     */
    @Override
    public String toString() {
        return super.toString() + "\t" + has5G;
    }

    /**
     * Compares this phone with another phone based on
     * inherited electronic information and 5G capability.
     *
     * @param p phone to compare with
     * @return true if both phones contain the same information
     */
    public boolean equals(phone p) {
        return super.equals(p) && has5G.equals(p.has5G);
    }
}