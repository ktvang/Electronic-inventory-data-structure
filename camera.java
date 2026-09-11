/**
 * Represents a camera electronic item.
 *
 * <p>Extends the electronic class by adding the camera's
 * megapixel specification.</p>
 */
public class camera extends electronic {

    private Integer megapixels;

    /**
     * Creates a camera with the specified identification,
     * electronic number, price, and megapixel count.
     *
     * @param eID unique electronic identifier
     * @param electronicNum electronic item number
     * @param price price of the camera
     * @param megapixels camera resolution in megapixels
     */
    public camera(
            String eID,
            int electronicNum,
            double price,
            Integer megapixels) {

        super(eID, electronicNum, price);
        this.megapixels = megapixels;
    }

    /**
     * Gets the camera's megapixel count.
     *
     * @return megapixel count
     */
    public Integer getMegapixels() {
        return megapixels;
    }

    /**
     * Sets the camera's megapixel count.
     *
     * @param megapixels new megapixel count
     */
    public void setMegapixels(Integer megapixels) {
        this.megapixels = megapixels;
    }

    /**
     * Returns a string representation of the camera.
     *
     * @return electronic information followed by megapixel count
     */
    @Override
    public String toString() {
        return super.toString() + "\t" + megapixels;
    }

    /**
     * Compares this camera with another camera based on
     * inherited electronic information and megapixel count.
     *
     * @param c camera to compare with
     * @return true if both cameras contain the same information
     */
    public boolean equals(camera c) {
        return super.equals(c) && megapixels.equals(c.megapixels);
    }
}