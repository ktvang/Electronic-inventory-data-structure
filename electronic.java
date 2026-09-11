/**
 * Represents a general electronic item in the inventory.
 *
 * <p>Stores the item's identifier, electronic number, and price.
 * Implements Comparable so electronic items can be maintained
 * in sorted order by the inventory collection.</p>
 */
public class electronic implements Comparable<electronic> {

    private String eID;
    private Integer electronicNum;
    private Double price;

    /**
     * Creates an electronic item with the specified information.
     *
     * @param eID unique electronic identifier
     * @param electronicNum electronic item number
     * @param price price of the item
     */
    public electronic(String eID, Integer electronicNum, Double price) {
        this.eID = eID;
        this.electronicNum = electronicNum;
        this.price = price;
    }

    /**
     * Gets the electronic identifier.
     *
     * @return electronic identifier
     */
    public String getEid() {
        return eID;
    }

    /**
     * Sets the electronic identifier.
     *
     * @param eID new electronic identifier
     */
    public void setEid(String eID) {
        this.eID = eID;
    }

    /**
     * Gets the electronic item number.
     *
     * @return electronic number
     */
    public Integer getElectronicNum() {
        return electronicNum;
    }

    /**
     * Sets the electronic item number.
     *
     * @param electronicNum new electronic number
     */
    public void setElectronicNum(Integer electronicNum) {
        this.electronicNum = electronicNum;
    }

    /**
     * Gets the item's price.
     *
     * @return item price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Sets the item's price.
     *
     * @param price new item price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Returns a string representation of the electronic item.
     *
     * @return electronic ID, number, and price
     */
    @Override
    public String toString() {
        return eID + "\t" + electronicNum + "\t" + price;
    }

    /**
     * Determines whether two electronic items contain
     * the same identifier, electronic number, and price.
     *
     * @param o electronic item to compare with
     * @return true if the items contain the same information
     */
    public boolean equals(electronic o) {
        if (o == null) {
            return false;
        }

        return eID.equalsIgnoreCase(o.eID)
                && electronicNum.equals(o.electronicNum)
                && price.equals(o.price);
    }

    /**
     * Compares electronic items for sorting.
     *
     * <p>Items are compared first by electronic ID,
     * then by electronic number, and finally by price.</p>
     *
     * @param o electronic item to compare with
     * @return negative, zero, or positive value based on ordering
     */
    @Override
    public int compareTo(electronic o) {
        int result = eID.compareToIgnoreCase(o.eID);

        if (result != 0) {
            return result;
        }

        result = electronicNum.compareTo(o.electronicNum);

        if (result != 0) {
            return result;
        }

        return price.compareTo(o.price);
    }
}