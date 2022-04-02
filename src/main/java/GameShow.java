import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GameShow {
    Random r = new Random();

    public boolean run(boolean isSwitch) {
        // create list of n-doors: 0 represents goat, 1 represents car
        List<Integer> doors = generateDoorConfig();
        // randomly select a door that the "player" is choosing
        int doorSelected = r.nextInt(3);
        // open all the doors (except the one the player has chosen) with goats in them: set value equal to 2
        revealGoats(doors, doorSelected);
        // determine if player has won game show
        if(isSwitch) {
            return doors.get(doorSelected) != 1;
        } else {
            return doors.get(doorSelected) == 1;
        }
    }

    private List<Integer> generateDoorConfig() {
        Integer[] arr = new Integer[3];
        Arrays.fill(arr, 0);
        List<Integer> doorConfiguration = Arrays.asList(arr);
        doorConfiguration.set(r.nextInt(3), 1);
        return doorConfiguration;
    }

    private void revealGoats(List<Integer> doors, int doorSelected) {
        for(Integer i: doors) {
            if(i != doorSelected && doors.get(doorSelected) != 1) {
                doors.set(i, 2);
            }
        }
    }
}

// Generate random config of doors (2 goats, 1 car): DONE
// randomly select one door to simulate user input: DONE
// "reveal" one goat --> essentially remove that door from list
// two test simulations:
// 1. user switches
// 2. user doesn't switch
// for each run n trials and then calculate probability of success
// should see that the first choice has a greater overall probability
// focus on margin of difference
