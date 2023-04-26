import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*Задан целочисленный список ArrayList. Найти минимальное, максимальное и 
среднее арифметичское этого списка. */
public class Task3 {

    public static int getSum(List<Integer> numbersList) {
        int sum = 0;
        for (int i: numbersList) {
            sum += i;
        }
        return sum;
    }
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        
        for (int i = 0; i < random.nextInt(10,20); i++) {
            numbers.add(i, random.nextInt(20));
        }
        System.out.println(numbers);

        int minElem = Collections.min(numbers);
        int maxElem = Collections.max(numbers);
        float average = getSum(numbers)* 1.0f/numbers.size();
        
        System.out.printf("Минимальный элемент: %d\n", minElem);
        System.out.printf("Максимальный элемент: %d\n", maxElem);
        //System.out.printf("%d, %d\n",getSum(numbers), numbers.size());
        System.out.printf("Средне арифметическое: %.2f\n", average);

    }
}
