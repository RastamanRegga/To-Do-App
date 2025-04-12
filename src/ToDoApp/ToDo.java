package ToDoApp;

import java.util.Scanner;

public class ToDo {

    static final int MAX = 5;
    static String [] list = new String[MAX];
    static int total = 0;

    static void addTask(String newTask) {
        list[total] = newTask;
        total++;
    }

    private static void checkTask(){
        if (total == 0){
            System.out.println("There No task added");
        } else {
            for (int i = 0; i < total; i++){
                System.out.println(i + 1 + "." + list[i]);
            }
        }
    }

    private static void delete(int numberTask){
        if (numberTask >= 1 && numberTask <= total){
            for (int i = numberTask - 1; i <total -1; i++){
                list[i] = list[i + 1];
            }
            total --;
        } else {
            System.out.println("Number is not valid");
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== To Do List ===== ");
            System.out.println("1. Add");
            System.out.println("2. Check");
            System.out.println("3. Delete");
            System.out.println("0. exit");
            System.out.println("Select from 0-3");

            choice = input.nextInt();
            switch (choice){
                case 0 -> System.out.println("Good Byee Have A Nice Day!");
                case 1 -> {
                    if (total == MAX) {
                        System.out.println("Task Is Full" );
                    }else {
                        System.out.println("=====Add=====");
                        input.nextLine();
                        String newTask = input.nextLine();
                        addTask(newTask);
                    }
                }
                case 2 -> {
                    System.out.println("=====Check=====");
                    checkTask();
                }
                case 3 -> {
                    System.out.println("=====Delete=====");
                    if (total >= 1){
                        checkTask();
                        System.out.println("Select number to delete");
                        int number = input.nextInt();
                        delete(number);
                    }else {
                        System.out.println("There no task been added");
                    }
                }
                default -> System.err.println("Please select one of the above");
            }

        } while (choice != 0);


    }
}
