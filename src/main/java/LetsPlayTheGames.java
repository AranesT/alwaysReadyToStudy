import java.util.*;

public class LetsPlayTheGames {

    /**
     * Ваша задача - реализовать класс, в котором буду находиться игры, в которые пользователь сможет сыграть.
     * Главная задача - сделать его легко масштабируемым, т.е. иметь возможность легко увеличить количество
     * доступных игр.
     */
    private static HashMap<Integer, String> nameOfGame = new HashMap<>();

    public static void main(String[] args) {
        listOfMap();
        Scanner scanner = new Scanner(System.in);
        String greeting = "";
        Set<Integer> keys = nameOfGame.keySet();
        Integer [] newKeys = new Integer[]{keys.size()};
        for (int i = 0; i <= newKeys.length; i++) {
            do {
                greeting = scanner.nextLine();
                if (Integer.parseInt(greeting) != newKeys[i]-1) {
                    System.out.println("Вы ввели некорректное значение. Попрбуйте снова: ");
                }
            }
            while (Integer.parseInt(greeting) != newKeys[i]-1);{
                switch (greeting) {
                    case "1":
                        verbalCounting();
                        break;

                }
            }
        }


    }

    public static void verbalCounting() {
        System.out.println("444");
    }

    public static void listOfMap() {
        nameOfGame.put(1, "Устный счет");
        nameOfGame.put(2, "Кости");
        System.out.println("Приветсвую, давай сыграем в игру! Все, что тебе нужно, только выбрать ее.");
        for (Map.Entry entry : nameOfGame.entrySet()) {
            System.out.println(entry);
        }
    }
}
