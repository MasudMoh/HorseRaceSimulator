//This class will be used to run the race class
public class MainRace {
    public static void main(String[] args) {
        Race R = new Race(20);

        Horse Horse1 = new Horse('♘',"PIPPI LONGSTOCKING",0.2);
        Horse Horse2 = new Horse('♞',"KOKOMO",0.2);
        Horse Horse3 = new Horse('♘',"EL JEFE",0.7);


        R.addHorse(Horse1 ,1);
        R.addHorse(Horse2 ,2);
        R.addHorse(Horse3,3);
        R.startRace();

    }
}
