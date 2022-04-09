package assets;

public class Note {
    private final int index;

    /**
     * Creates a new note
     *
     * @param noteType the note type (e.g. C, D, E ...). Cannot be null.
     * @param accidental the accidental (sharp or flat). Can be null.
     */
    public Note(NoteType noteType, Accidental accidental) {
        if (noteType == null) {
            throw new IllegalArgumentException("Error: the note type cannot be null");
        }
        this.index = calculateIndex(noteType, accidental);
    }

    /**
     * Creates a new note with a given index
     *
     * @param index the index
     */
    public Note(int index) {

        /*
        while (index > Config.MAX_INDEX || index < Config.MIN_INDEX) {
            if (index > Config.MAX_INDEX) {
                index = index - Config.MAX_INDEX;
            }
            else {
                index = index + Config.MAX_INDEX;
            }
        }
         */

        index = index % Config.MAX_INDEX;
        this.index = index;
    }

    private int calculateIndex(NoteType noteType, Accidental accidental) {
        int index = noteType.index;
        switch (accidental) {
            case SHARP:
                index++;
                if (index > Config.MAX_INDEX) {
                    index = Config.MIN_INDEX;
                }
                break;
            case FLAT:
                index--;
                if (index < Config.MIN_INDEX) {
                    index = Config.MAX_INDEX;
                }
                break;
        }
        return index;
    }

    /**
     * Returns a string of this note's representation, depending on the accidental
     *
     * @param accidental the accidental
     * @return the string representation
     */
    public String toString(Accidental accidental) {
        // TODO
        return "";
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return this.toString(Accidental.SHARP);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Note)) {
            return false;
        }
        else {
            Note note = (Note) o;
            return note.index == this.index;
        }
    }
}
