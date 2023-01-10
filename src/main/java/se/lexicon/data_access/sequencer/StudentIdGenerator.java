package se.lexicon.data_access.sequencer;

public class StudentIdGenerator {

    public static int getSequencer() {
        return sequencer;
    }

    public static void setSequencer(int sequencer) {
        StudentIdGenerator.sequencer = sequencer;
    }

    private static int sequencer = 0;

    private static int nextId() {

        return ++sequencer;
    }
}
