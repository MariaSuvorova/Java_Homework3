/*Даны два ArrayList из целых чисел. Написать функции, которые вычисляют разницу 
коллекций:
Разность:
A - B = все числа из первой коллекции, которые не содержатся во второй коллекции
B - A = все числа из второй коллекции, которые не содержатся в первой
Симметрическая разность:
A ^ B = числа из первой коллекции, которых нет во второй, А ТАКЖЕ числа из 
второй, которых нет в первой */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Task4 {
    public static List<Integer> ListAexpB(List<Integer> numA, List<Integer> numB) {
        List<Integer> result = new ArrayList<>();
        boolean flag = false;

        for (int i = 0; i < numA.size(); i++) {
            for (int j = 0; j < numB.size(); j++) {
                if (numA.get(i) == numB.get(j)) flag = true;
                }
            if (flag == false) result.add(numA.get(i));
            else flag = false;
            }   
        List<Integer> distinctResult = result.stream().distinct().collect(Collectors.toList());
        return distinctResult;
    }

    public static void main(String[] args) {
        List<Integer> numbers1 = new ArrayList<>();
        List<Integer> numbers2 = new ArrayList<>();
        Random random = new Random();
        
        for (int i = 0; i < random.nextInt(10,20); i++) {
            numbers1.add(i, random.nextInt(20));
            numbers2.add(i, random.nextInt(20));
        }
        System.out.println(numbers1);
        System.out.println(numbers2);
        List<Integer> listAexpB = ListAexpB(numbers1, numbers2);
        System.out.println(listAexpB);
        List<Integer> listBexpA = ListAexpB(numbers2, numbers1);
        System.out.println(listBexpA);
        List<Integer> listABexp = new ArrayList<>(listAexpB);
        listABexp.addAll(listBexpA);
        System.out.println(listABexp);
    }
}

