import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);
        List<Integer> items = new ArrayList<>();
        System.out.println("Enter target:");
        int target = scanner.nextInt();
        System.out.println("Enter numbers (type '0' to finish.):");

        while (true) {
            int input = scanner.nextInt();
            if (input == 0){
                break;
            }
            items.add(input);
        }
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(items.stream().mapToInt(Integer::intValue).toArray()
,target)));
    }
}