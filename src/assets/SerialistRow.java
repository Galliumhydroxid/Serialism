package assets;

/**
 * This class represents a row of {@link Config#MAX_INDEX} notes. It cannot contain duplicates.
 *
 * @author Galliumhydroxid
 * @version 1.0
 */
public class SerialistRow {

    private final Note[] notes;

    /**
     * Initializes a new serialist row
     *
     * @param notes the array of notes. Must be {@link Config#MAX_INDEX} long and cannot contain duplicates.
     */
    public SerialistRow(Note[] notes) {
        if (notes.length != Config.MAX_INDEX) {
            throw new IllegalArgumentException("Error: the row has an illegal length");
        }
        if (containsDuplicates(notes)) {
            throw new IllegalArgumentException("Error: that row contains duplicates");
        }
        this.notes = notes;
    }

    private boolean containsDuplicates(Note[] notes) {
        for (int i = 0; i < notes.length; i++) {
            for (int a = 0; a < notes.length; a++) {
                if (notes[i].equals(notes[a]) && i != a) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Gets the prime of this row transposed by a given index delta
     *
     * @param indexDelta the index delta
     * @return the prime
     */
    public SerialistRow getPrime(int indexDelta) {
        for (int i = 0; i < notes.length; i++) {
            notes[i] = new Note(notes[i].getIndex() + indexDelta);
        }

    }
}
