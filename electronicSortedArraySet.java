/**
 * Represents a sorted set of electronic items stored in an array.
 *
 * <p>The collection maintains electronic items in sorted order,
 * prevents duplicate records, and supports searching, removal,
 * retrieval, and filtering by electronic category.</p>
 */
public class electronicSortedArraySet {

    private electronic[] electronicAry;

    private static final Integer MAX = 100;

    private int size;

    /**
     * Creates an empty sorted electronic set with a maximum
     * capacity of 100 items.
     */
    public electronicSortedArraySet() {
        electronicAry = new electronic[MAX];
        size = 0;
    }

    /**
     * Gets the number of electronic items currently stored.
     *
     * @return number of items in the set
     */
    public int size() {
        return size;
    }

    /**
     * Inserts an electronic item while maintaining sorted order.
     *
     * <p>Duplicate items are not inserted. Items greater than
     * the new item are shifted one position to make room.</p>
     *
     * @param e electronic item to insert
     */
    public void insert(electronic e) {

        // Prevent duplicate records.
        if (indexOf(e) != -1) {
            return;
        }

        // Prevent insertion when the array is full.
        if (size >= MAX) {
            return;
        }

        int pos = 0;

        // Find the correct position based on electronic ordering.
        while (pos < size
                && electronicAry[pos].compareTo(e) < 0) {
            pos++;
        }

        // Shift elements to make room for the new item.
        for (int i = size; i > pos; i--) {
            electronicAry[i] = electronicAry[i - 1];
        }

        electronicAry[pos] = e;
        size++;
    }

    /**
     * Searches for an electronic item in the set.
     *
     * @param e electronic item to find
     * @return index of the item, or -1 if it is not found
     */
    public int indexOf(electronic e) {
        for (int i = 0; i < size; i++) {
            if (electronicAry[i].equals(e)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Removes an electronic item from the set.
     *
     * <p>Items after the removed element are shifted left to
     * maintain the collection's ordering.</p>
     *
     * @param e electronic item to remove
     * @return true if the item was removed; false if it was not found
     */
    public boolean remove(electronic e) {
        int index = indexOf(e);

        if (index == -1) {
            return false;
        }

        // Shift remaining elements to fill the empty position.
        for (int i = index; i < size - 1; i++) {
            electronicAry[i] = electronicAry[i + 1];
        }

        electronicAry[size - 1] = null;
        size--;

        return true;
    }

    /**
     * Retrieves an electronic item at a specified index.
     *
     * @param index position of the item
     * @return electronic item at the index, or null if the index is invalid
     */
    public electronic grab(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        return electronicAry[index];
    }

    /**
     * Creates a new sorted set containing items from a specified category.
     *
     * <p>Supported categories are Phone, Laptop, and Camera.
     * An empty string returns only items that are direct instances
     * of the electronic superclass.</p>
     *
     * @param type category to filter by
     * @return sorted set containing matching items, or null for an
     *         unsupported category
     */
    public electronicSortedArraySet categorySet(String type) {
        electronicSortedArraySet result =
                new electronicSortedArraySet();

        if (type.equalsIgnoreCase("Phone")) {
            for (int i = 0; i < size; i++) {
                if (electronicAry[i] instanceof phone) {
                    result.insert(electronicAry[i]);
                }
            }

            return result;
        }

        if (type.equalsIgnoreCase("Laptop")) {
            for (int i = 0; i < size; i++) {
                if (electronicAry[i] instanceof laptop) {
                    result.insert(electronicAry[i]);
                }
            }

            return result;
        }

        if (type.equalsIgnoreCase("Camera")) {
            for (int i = 0; i < size; i++) {
                if (electronicAry[i] instanceof camera) {
                    result.insert(electronicAry[i]);
                }
            }

            return result;
        }

        // An empty string returns only direct electronic objects.
        if (type.equals("")) {
            for (int i = 0; i < size; i++) {
                if (!(electronicAry[i] instanceof phone)
                        && !(electronicAry[i] instanceof laptop)
                        && !(electronicAry[i] instanceof camera)) {

                    result.insert(electronicAry[i]);
                }
            }

            return result;
        }

        return null;
    }

    /**
     * Returns all electronic items in the set as a string.
     *
     * @return string containing each electronic item on a separate line
     */
    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < size; i++) {
            result += electronicAry[i] + "\n";
        }

        return result;
    }
}