package se.lexicon.data_access.sequencer;

public class StudentIdGenerator {


    private static int sequencer = 0;

    public static int nextId() {
        int id = ++sequencer;
        setSequencer(id);
        return id;

    }

    public static int getSequencer() {

        return sequencer;
    }

    public static void setSequencer(int sequencer) {
        StudentIdGenerator.sequencer = sequencer;
    }
}
