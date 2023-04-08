import java.util.Scanner;

public class Service {
    static void login(AppUser user) throws Exception {
        user = Authentification.login();
    }

    static void register(AppUser user) throws Exception {
        user = Authentification.register();
    }

    static void add_project(AppUser user) {
        TaskBoard taskboard = user.TaskBoard();
        Scanner myObj = new Scanner(System.in);
        Project proj = taskboard.addProject();
        while (true) {
            System.out.println("Please choose an option:");
            System.out.println("1. Add Task");
            System.out.println("2. Go to menu");
            int option = myObj.nextInt();
            int a = 0;
            switch (option) {
                case 1:
                    proj.addTask();
                    a = 1;
                    break;
                case 2:
                    break;

                default:
                    System.out.println("Invalid option");
            }
            if (option == 2) {
                break;
            }
        }
    }

    static void see_project(AppUser user) {
        Scanner myObj = new Scanner(System.in);
    System.out.println("Enter the name of the project: ");//notificarile
    String nae = myObj.nextLine();
    String name = myObj.nextLine();
    TaskBoard taskboard = user.TaskBoard();
    Project project = taskboard.getProject(name);
    //notificari
    project.sendNotifications();
    while (true) {
        System.out.println("Please choose an option:");
        System.out.println("1. Add Task");

        System.out.println("2. See all tasks");
        System.out.println("3. Back to menu");
        int option = myObj.nextInt();
        int a = 0;
        switch (option) {
            case 1:
                project.addTask();
                a=1;
                break;
            case 2:
                a=1;
                project.printTasks();
                myObj = new Scanner(System.in);
                System.out.println("Please choose a task:");
                name= myObj.nextLine();
                Task task = project.getTask(name);
                System.out.println("Please choose an option:");
                System.out.println("1. Remove Task");
                System.out.println("2. Edit Task");
                System.out.println("3. See task");
                System.out.println("4. Back to menu");
                option = myObj.nextInt();
                switch (option) {
                    case 1:
                        project.removeTask(task);
                        System.out.println("Task removed");
                        break;
                    case 2:
                        task.editTask();
                        break;
                    case 3:
                        task.seeTask();
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Invalid option");
                }
                if (option == 4) {
                    break;
                }
                break;

            case 3:

                break;

            default:
                System.out.println("Invalid option");
        }
        if (option == 3) {
            break;
        }
    }
}




}



