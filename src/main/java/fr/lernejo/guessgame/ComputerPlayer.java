package fr.lernejo.guessgame;

public class ComputerPlayer implements Player{


    @Override
    public long askNextGuess(long min , long max)  {
       return (min+max)/2;
    }


    @Override
    public long askNextGuess() {
        return 0;
    }

    @Override
    public void respond(boolean lowerOrGreater) {

        if(lowerOrGreater){
            System.out.println("le nombre saisi est plus grand");
        }else {
            System.out.println("le nombre saisi est plus petit");
        }
    }


}
