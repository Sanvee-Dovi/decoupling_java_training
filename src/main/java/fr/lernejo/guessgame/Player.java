package fr.lernejo.guessgame;

public interface Player {
    long askNextGuess(long min, long max);

    long askNextGuess();


    /**
     * Called by {@link Simulation} to inform that the previous guess was lower or greater that the number to find.
     */
    void respond(boolean lowerOrGreater);
}
