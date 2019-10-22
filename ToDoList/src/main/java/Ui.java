import model.Project;
import model.Status;
import model.Task;

import java.time.LocalDate;
import java.util.Scanner;

public class Ui {

    private Scanner scanner = new Scanner(System.in);
    GroupOfTask groupOfTask = new GroupOfTask();
    // greeting message
    public void greet(){
        System.out.println("Welcome to my TodoList!!!!");
        start();
    }
    // to see task's status
    private void start() {
        groupOfTask.loadList();
        int notDoneTasks = 0;
        int doneTasks = 0;
        for (Task task: groupOfTask.getList()) {
            if(task.getStatus() == Status.Done){
                doneTasks ++;
            } else {
                notDoneTasks ++;
            }
        }
        System.out.printf("You %d have tasks todo and %d tasks are done!\n", notDoneTasks, doneTasks);
        int command = 0;
        do {
            command = firstMenu();
        } while (command == -1);
        switch (command){
            case 1: showTypeMenu(); break;
            case 2: addTask(); break;
            case 3:  editTaskMenu(); break;
            case 4:  groupOfTask.saveList(); break;
        }
        groupOfTask.saveList();
    }

    private int firstMenu(){
        System.out.println("Pick an option:\n" +
                ">> (1) Show Task List (by date or project)\n" +
                ">> (2) Add New Task\n" +
                ">> (3) Edit Task (update, mark as done, remove)\n" +
                ">> (4) Save and Quit\n");
        return getCommmand(1,4);
    }

    private void showTypeMenu(){
        System.out.println("How???\n (1) By Date?\n (2) By Project?");
        int option = getCommmand(1,2);
        switch (option){
            case 1: groupOfTask.sortTaskByDate(); break;
            case 2: groupOfTask.sortTaskByProject(); break;
        }
        System.out.println("--------------------------------------\n\n");
        start();
    }

    private void editTaskMenu(){
        System.out.println("What do you want to change?\n(1) Title?\n(2) Project?\n(3) Duedate?\n(4) Status?");
        int option = getCommmand(1,4);
        switch (option){
            case 1: editName(taskToEdit()); groupOfTask.saveList(); break;
            case 2: editDate(taskToEdit()); groupOfTask.saveList(); break;
            case 3: editProject(taskToEdit()); groupOfTask.saveList(); break;
            case 4: editStatus(taskToEdit()); groupOfTask.saveList(); break;
        }
        System.out.println("--------------------------------------\n\n");
        start();
    }

    private void addTask(){
        String title = getTitle();
        LocalDate date = getDueDate();
        Project project = getProject();

        groupOfTask.addTask(new Task(title, date, project));
        groupOfTask.saveList();
        start();
    }

    private String getTitle() {
        System.out.println("Enter your Task name:");
        return validateString("Task title");
    }

    private LocalDate getDueDate() {
        System.out.println("Enter your Task due date:");
        return validateDate();
    }


    private Project getProject() {
        return Project.of(validateString("Project name"));
    }



    private int getCommmand(int min, int max){
        System.out.printf("Please choose a Number between %d and %d: \n", min, max);
        int a = -1;
        try{
            scanner = new Scanner(System.in);
            a = scanner.nextInt();
            if(a < min || a > max){
                return -1;
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Some thing went wrong, try again please!!!");
        }
        return a;
    }

    private Task taskToEdit(){
        groupOfTask.showAll(groupOfTask.getList());
        int index = getCommmand(1, groupOfTask.getList().size()) - 1;
        return groupOfTask.getList().get(index);
    }

    private void editName(Task taskToEdit){
        System.out.println("Enter the new title");
        taskToEdit.setTitle(validateString("New title"));
    }

    private void editStatus(Task taskToEdit) {
        System.out.println("Enter task new Status:");
        taskToEdit.setStatus(validateStatus());
    }

    private void editProject(Task taskToEdit) {
        System.out.println("Enter task's new Project name:");
        Project project = Project.of(validateString("New project name"));
        taskToEdit.setProject(project);
    }

    private void editDate(Task taskToEdit) {
        taskToEdit.setDate(validateDate());
    }


    public String validateString(String inputType){
        boolean valid = false;
        String input = "";
        do {
            scanner = new Scanner(System.in);
            input = scanner.nextLine();
            if(!input.trim().isEmpty()){
                valid= true;
            } else {
                System.out.printf("%s can not be blank!!!\nPlease enter a valid %s:\n", inputType, inputType);
            }
        } while (!valid);
        return input;
    }

    private LocalDate validateDate() {
        boolean valid = false;
        LocalDate dueDate = LocalDate.now();
        do {
            String date = scanner.nextLine();
            try{
                dueDate = LocalDate.parse(date);
                if (!dueDate.isBefore(LocalDate.now())){
                    valid = true;
                }
            } catch(Exception e) {
                System.out.println("Not a valid future date!\nPlease enter date like (2020-01-01):");
            }
        } while(!valid);
        return dueDate;
    }

    private Status validateStatus() {
        scanner = new Scanner(System.in);
        Status newStatus;
        do{
            String status = scanner.nextLine().trim();
            newStatus = Status.of(status);
            System.out.println("Please choose 'Done' or 'Not_Done' as Status");
        } while(newStatus == null);
        return newStatus;
    }
}
