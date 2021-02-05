import java.util.*;

public class Main {

    TodoList todoList = new TodoList(); //private TodoList todoList = new TodoList();

    public void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
            Scanner scanner = new Scanner(System.in);
            String str = " ";

            while (!str.equals("EXIT")) {
                System.out.println("Введите команду или \"EXIT\" для завершения: ");
                str = scanner.nextLine();
                String[] commands = str.split("\\s+");

                String command = " ";
                String deed = null;
                int index = -1;

                if (str.matches("^[\\p{Upper}]+")) {
                    command = str.trim();

                } else if (str.matches("^[\\p{Upper}]+\\s+\\d+")) {
                    command = TodoList.comm(commands);
                    index = TodoList.ind(commands);

                } else if (str.matches("^[\\p{Upper}]+\\s+\\d+.+")) {
                    command = TodoList.comm(commands);
                    index = TodoList.ind(commands);
                    deed = TodoList.scanDeed(commands, 2);

                } else if (str.matches("^[\\p{Upper}]+.+")) {
                    command = TodoList.comm(commands);
                    deed = TodoList.scanDeed(commands, 1);

                } else {
                    System.out.println("Неверная команда.");
                }

                switch (command) {

                    case ("LIST"):
                        System.out.println("Список дел:");
                        for (int i = 0; i < TodoList.deeds.size(); i++) {
                            System.out.println("Работа номер: " + i + " " + TodoList.deeds.get(i));
                        }
                        break;

                    case ("ADD"):
                        if (index > -1 && index < TodoList.deeds.size()) {
                            TodoList.deeds.add(index, deed);
                            System.out.println("Добавлена работа \"" + deed + "\" с индексом " + index);
                        } else if (index > TodoList.deeds.size()) {
                            System.out.println("Укажите индекс не более " + (TodoList.deeds.size() - 1));
                        } else {
                            TodoList.deeds.add(deed);
                        }
                        break;

                    case ("EDIT"):
                        if (index > -1 && index < TodoList.deeds.size()) {
                            TodoList.deeds.set(index, deed);
                            System.out.println("Работа под индексом " + index + " изменена на \"" + deed + "\"");
                        } else {
                            System.out.println("Неверная команда. Укажите индекс редактируемого дела" +
                                    " значением не более " + (TodoList.deeds.size() - 1));
                        }
                        break;

                    case ("DELETE"):

                        if (index > -1 && index < TodoList.deeds.size()) {
                            TodoList.deeds.remove(index);
                            System.out.println("Работа с индексом " + index + " удалена");
                        } else {
                            System.out.println("Неверная команда. Укажите индекс удаляемого дела" +
                                    " значением не более " + (TodoList.deeds.size() - 1));
                        }
                        break;
                    case ("EXIT"):
                        System.out.println("Работа завершена.");
                        break;

                    default:
                        System.out.println("Такой команды нет. \nДоступные команды: LIST, ADD, EDIT, DELETE.");
                }
            }
    }
}
