package Week11;

public class Sound {
    private int[] samples;
    public int limitAmplitude(int limit){
        int counter = 0;
        for(int i = 0; i<samples.length; i++){
            if(samples[i]>limit){
                samples[i] = limit;
                counter++;
            }
            if(samples[i]<0-limit){
                samples[i] = 0-limit;
                counter++;
            }
        }
        return counter;
    }
    public void trimSilenceFromBeginning(){
        int counter = 0;
        int i = 0;
        while(samples[i]==0){
            counter++;
            i++;
        }
    }
}
