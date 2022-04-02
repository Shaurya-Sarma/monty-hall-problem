public class App {
    public static void main(String ...args) {
        int trials = Integer.parseInt(args[0]);
        System.out.println("NUMBER OF TRIALS: " + trials);
        System.out.println("------------------------------------------------");
        int switchWinCounter = 0;
        int noSwitchWinCounter = 0;
        GameShow g = new GameShow();
        // SIMULATION 1: PLAYER SWITCHES
        for(int i = 1; i <= trials; i++) {
            if(new GameShow().run(true)) {
                switchWinCounter++;
            }
        }
        // SIMULATION 2: PLAYER DOES NOT SWITCH
        for(int i = 1; i <= trials; i++) {
            if(new GameShow().run(false)) {
                noSwitchWinCounter++;
            }
        }
        calculateWinPercent(trials, switchWinCounter, noSwitchWinCounter);
    }

    private static void calculateWinPercent(int trials, int switchWins, int noSwitchWins) {
        System.out.println("SIMULATION 1: PLAYER SWITCHES");
        System.out.println("S WINS: " + switchWins);
        System.out.println("WIN PERCENTAGE: " + ((float)switchWins / trials) * 100 + "%");
        System.out.println("------------------------------------------------");
        System.out.println("SIMULATION 2: PLAYER DOES NOT SWITCH");
        System.out.println("NS WINS: " + noSwitchWins);
        System.out.println("WIN PERCENTAGE: " + ((float)noSwitchWins / trials) * 100 + "%");
    }
}