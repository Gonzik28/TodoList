import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TodoList {

    public static List deeds = new ArrayList<>(); //public static List deeds = new ArrayList<>();

    public static String comm(String[] string) {
        return string[0].trim();
    }

    public static int ind(String[] string) {
        return Integer.parseInt(string[1].trim());
    }

    public static String scanDeed(String[] string, int index) {
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < string.length; i++) {
            sb.append(string[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        deeds.add(todo);
    }

    public void add(int index, String todo) {
        if(index > deeds.size()){
            System.out.println("Добавление в указанный индекс невозможно");
        }
        else {
            deeds.add(index, todo);
        }
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
    }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        if(index > deeds.size()){
            System.out.println("Изменение в указанном индексе невозможно");
        }
        else {
            deeds.set(index, todo);
        }
    }

    public void delete(int index) {
        if(index >deeds.size()){
            System.out.println("Удаление невозможно");
        }
        else {
            deeds.remove(index);
        }
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
    }

    public List getTodos() {
        // TODO: вернуть список дел
        Iterator itr = deeds.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        return deeds;
    }

}