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

static void remove_project(AppUser user){

    System.out.println("Enter the name of the project: ");
    Scanner myObj = new Scanner(System.in);
    String name = myObj.nextLine();
    TaskBoard taskboard = user.TaskBoard();
    Project project = taskboard.getProject(name);
    taskboard.removeProject(project);
    System.out.println("Project removed");
}

static void see_mylisy(AppUser user){
    TaskBoard taskboard = user.TaskBoard();
    MyList myList = taskboard.getMyList();
    Scanner myObj = new Scanner(System.in);
    //notificari
    myList.sendNotifications();
    while (true) {
        System.out.println("Please choose an option:");
        System.out.println("1. Add Task");

        System.out.println("2. See all tasks");
        System.out.println("3. Back to menu");
        int option = myObj.nextInt();
        int a = 0;
        switch (option) {
            case 1:
                myList.addTask();
                a=1;
                break;
            case 2:
                a=1;
                myList.printTasks();
                myObj = new Scanner(System.in);
                System.out.println("Please choose a task:");
                String name= myObj.nextLine();
                Task task = myList.getTask(name);
                System.out.println("Please choose an option:");
                System.out.println("1. Remove Task");
                System.out.println("2. Edit Task");
                System.out.println("3. See task");
                System.out.println("4. Back to menu");
                option = myObj.nextInt();
                switch (option) {
                    case 1:
                        myList.removeTask(task);
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
}}
    static void see_taskboard(AppUser user){
        System.out.println("MyList");
        TaskBoard taskboard = user.TaskBoard();
        taskboard.sortProjects();
        taskboard.printProjects();
    }

    static void add_workspace(AppUser user){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please choose an option:");
        System.out.println("1.Enter the name of a project to make it workspace: ");
        System.out.println("2.Create a new workspace: ");
        System.out.println("3.Back to menu");
        int option = myObj.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter the name of the project: ");

                String name = myObj.nextLine();
                TaskBoard taskboard = user.TaskBoard();
                Project project = taskboard.getProject(name);
                Workspace workspace = new Workspace( project, user);
                user.addWorkspace(workspace);
                System.out.println("Workspace created");
                while(true){
                    System.out.println("Choose an option:");
                    System.out.println("1. Invite member");
                    System.out.println("2. Back to menu");
                    option = myObj.nextInt();
                    switch (option) {
                        case 1:
                            System.out.println("Enter the username of the member: ");
                            String member = myObj.nextLine();
                            member = myObj.nextLine();
                            workspace.sendInvitation(Authentification.getUserByUsername(member));
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("Invalid option");
                    }
                    if (option == 2) {
                        break;
                    }}
                break;
            case 2://create new workspace
                taskboard = user.TaskBoard();
                Project project1 = taskboard.addProject();
                Workspace workspace1 = new Workspace( project1, user);
                user.addWorkspace(workspace1);
                while(true){
                    System.out.println("Choose an option:");
                    System.out.println("1. Invite member");
                    System.out.println("2. Back to menu");
                    option = myObj.nextInt();
                    switch (option) {
                        case 1:
                            System.out.println("Enter the username of the member: ");
                            String member = myObj.nextLine();
                            member = myObj.nextLine();
                            workspace1.sendInvitation(Authentification.getUserByUsername(member));
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("Invalid option");
                    }
                    if (option == 2) {
                        break;
                    }}



                break;
            case 3://back to menu
                break;
            default:
                System.out.println("Invalid option");
        }

    }

    static void see_workspace(AppUser user){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Inviations");
        for (Workspace i : user.getInvitations()) {
            System.out.println(i.getProject().getName());
            System.out.println("Do you want to accept the invitation? (y/n)");
            String answer = myObj.nextLine();
            answer = myObj.nextLine();
            if (answer.equals("y")) {
                user.acceptInvitation(i);
                i.addUser(user);
                i.removeInvitation(user);
            }
            else{
                i.removeInvitation(user);
                user.declineInvitation(i);
            }
        }
        System.out.println("Choose an option:");
        System.out.println("1. Enter the name of the workspace");
        System.out.println("2. Back to menu");
        int option = myObj.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter the name of the workspace: ");
                String name = myObj.nextLine();

                Workspace workspace = user.getWorkspace(name);
                while(true){
                    System.out.println("Choose an option:");
                    System.out.println("1. See tasks");

                    System.out.println("2. Back to menu");
                    option = myObj.nextInt();
                    switch (option) {
                        case 1:
                            for (Task i : workspace.getTasks()) {
                                System.out.println(i.getName());
                                System.out.println(i.getinCharge());
                                System.out.println("Do you want to assign youself this task? (y/n)");
                                String answer = myObj.nextLine();
                                answer = myObj.nextLine();
                                if (answer.equals("y")) {
                                    i.setinCharge(user);
                                }

                            }
                            break;

                        case 2:
                            break;
                        default:
                            System.out.println("Invalid option");
                    }
                    if (option == 3) {
                        break;
                    }}
                break;
            case 2:
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    static void logout(AppUser user){
        System.out.println("Thank you for using the Task Manager!");
        Authentification.logout();
    }


}



