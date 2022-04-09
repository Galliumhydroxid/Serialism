package assets;

public enum NoteType {

    C(1),
    D(3),
    E(5),
    F(6),
    G(8),
    A(10),
    B(12);

    public final int index;

    NoteType(int index) {
        this.index = index;
    }
}
