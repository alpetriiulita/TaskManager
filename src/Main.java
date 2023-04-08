import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to the Task Manager!");
        while (true) {//loop

            Scanner myObj = new Scanner(System.in);
            System.out.println("Please choose an option:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            int option = myObj.nextInt();
            AppUser user = null;

            switch (option) {
                case 1:
                    user = Authentification.login();
                    break;
                case 2:
                    user = Authentification.register();
                    break;
                case 3:
                    System.out.println("Thank you for using the Task Manager!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
            while (true) {//menu
                myObj = new Scanner(System.in);
                System.out.println("Please choose an option:");
                System.out.println("1. Add Project");
                System.out.println("2. See Project");
                System.out.println("3. Remove Project");
                System.out.println("4. See MyList");
                System.out.println("5. See TaskBoard");
                System.out.println("6. Add Workspace");
                System.out.println("7. See Workspace");
                System.out.println("8. Logout");

                option = myObj.nextInt();

                switch (option) {
                    case 1://add project
                        TaskBoard taskboard = user.TaskBoard();

                        Project proj= taskboard.addProject();
                        while (true) {
                            System.out.println("Please choose an option:");
                            System.out.println("1. Add Task");
                            System.out.println("2. Go to menu");
                            option = myObj.nextInt();
                            int a= 0;
                            switch (option) {
                                case 1:
                                    proj.addTask();
                                    a=1;
                                    break;
                                case 2:
                                    break;

                                default:
                                    System.out.println("Invalid option");
                            }
                            if (option == 2) {
                                break;
                            }
                            break;

                        }

                case 2:// see project
                    System.out.println("Enter the name of the project: ");//notificarile
                    String nae = myObj.nextLine();
                    String name = myObj.nextLine();
                    taskboard = user.TaskBoard();
                    Project project = taskboard.getProject(name);
                    //notificari
                    project.sendNotifications();
                    while (true) {
                        System.out.println("Please choose an option:");
                        System.out.println("1. Add Task");

                        System.out.println("2. See all tasks");
                        System.out.println("3. Back to menu");
                        option = myObj.nextInt();
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
                    break;

                case 3:
                    System.out.println("Enter the name of the project: ");
                    nae = myObj.nextLine();
                    name = myObj.nextLine();
                    taskboard = user.TaskBoard();
                    project = taskboard.getProject(name);
                    taskboard.removeProject(project);
                    System.out.println("Project removed");
                    break;
                case 4:

                    taskboard = user.TaskBoard();
                    MyList myList = taskboard.getMyList();
                    //notificari
                    myList.sendNotifications();
                    while (true) {
                        System.out.println("Please choose an option:");
                        System.out.println("1. Add Task");

                        System.out.println("2. See all tasks");
                        System.out.println("3. Back to menu");
                        option = myObj.nextInt();
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
                                name= myObj.nextLine();
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
                    }
                    break;
                case 5://see taskboard
                    System.out.println("MyList");
                    taskboard = user.TaskBoard();
                    taskboard.sortProjects();
                    taskboard.printProjects();
                    break;
                case 6://add workspace
                    myObj = new Scanner(System.in);
                    System.out.println("Please choose an option:");
                    System.out.println("1.Enter the name of a project to make it workspace: ");
                    System.out.println("2.Create a new workspace: ");
                    System.out.println("3.Back to menu");
                    option = myObj.nextInt();
                    switch (option) {
                        case 1:
                            System.out.println("Enter the name of the project: ");
                            nae = myObj.nextLine();
                            name = myObj.nextLine();
                            taskboard = user.TaskBoard();
                            project = taskboard.getProject(name);
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





                    break;

                case 7://see workspaces
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
                    option = myObj.nextInt();
                    switch (option) {
                        case 1:
                            System.out.println("Enter the name of the workspace: ");
                            name = myObj.nextLine();

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

                    break;
                case 8:
                    System.out.println("Thank you for using the Task Manager!");
                    Authentification.logout();
                    break;
                default:
                    System.out.println("Invalid option");


            }
            if (option == 8) {
                break;
            }
        }



        }

    }

}